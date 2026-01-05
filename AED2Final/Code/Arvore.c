#include "../Headers/Arvore.h"
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>
#include <time.h>

//-----------------------ARVORE BINARIA------------------------------------

Apontador criar_no(Palavra x, int offset) {
    Apontador novo = (Apontador)malloc(sizeof(No));
    if (novo == NULL) {
        printf("Erro ao alocar memória para novo nó.\n");
        exit(1);
    }
    novo->palavra = x;
    novo->palavra.offsets[0] = offset;
    novo->palavra.count_offsets = 1;
    novo->palavra.frequencia = 1;
    novo->esq = NULL;
    novo->dir = NULL;
    novo->fator = 0; // Utilizado para o fator de balanceamento da AVL
    return novo;
}

void Insere(Palavra x, Apontador *p, int offset) {
    if (*p == NULL) { // Se o nó for nulo
        *p = criar_no(x, offset); // Cria um novo nó
        return;
    }

    if (strcmp(x.palavra, (*p)->palavra.palavra) < 0) {        // Se a palavra for menor que a raiz
        Insere(x, &(*p)->esq, offset);                         // Insere na subárvore esquerda (chama por recursão)
    } else if (strcmp(x.palavra, (*p)->palavra.palavra) > 0) { // Se a palavra for maior que a raiz
        Insere(x, &(*p)->dir, offset);                         // Insere na subárvore direita (chama por recursão)
        
    } else {                                                           // Se a palavra já existir
        (*p)->palavra.frequencia++;                                    // Incrementa a frequência
        (*p)->palavra.offsets[(*p)->palavra.count_offsets++] = offset; // Adiciona o offset
    }
}

void inserir_palavra_arvore(Apontador *raiz, char *palavra, int offset) {
    char palavra_modificada[50];
    int j = 0;
    
 // Verifica se é letra e converte para minúscula
    for (int i = 0; palavra[i] != '\0'; i++) {
        if (eh_letra(palavra[i])) {
            palavra_modificada[j] = tolower(palavra[i]);
            j++;
        }
    }
    palavra_modificada[j] = '\0'; // Bota o \0 para indicar o fim da palavra

    if (strlen(palavra_modificada) <= 3) return; // Se a palavra tiver menos de 3 caracteres, retorna

    Palavra nova; // Cria uma nova palavra
    strcpy(nova.palavra, palavra_modificada); // Copia a palavra modificada para a struct
    nova.frequencia = 1; // Inicia a frequência
    nova.count_offsets = 1; // Inicia o counter
    nova.offsets[0] = offset; // Insere o offset

    Insere(nova, raiz, offset); // Insere a palavra na árvore
}

void adicionar_palavras_arvore(Citacao citacoes[MAX_CITACOES], int total_citacoes, Apontador *raiz) {
    clock_t inicio, fim;
    double tempo;
    inicio = clock();

    for (int i = 0; i < total_citacoes; i++) {                 // Percorre todas as citações
        char *copia = malloc(strlen(citacoes[i].citacao) + 1); // +1 para o \0
        if (copia == NULL) {
            printf("Erro de alocacao de memoria.\n"); // Teste erro alocação
            return;
        }

        strcpy(copia, citacoes[i].citacao);   // Copia a citação para copia
        char *separador = strtok(copia, " "); // Separa a citação em palavras pelos espaços

        while (separador != NULL) {                                       // Enquanto tiver palavras na citação
            inserir_palavra_arvore(raiz, separador, citacoes[i].offset);  // Insere a palavra na árvore
            separador = strtok(NULL, " "); // Continua de onde parou
        }

        free(copia); // Libera a memória da copia para possivel reutilização
    }

    fim = clock();
    tempo = (double)(fim - inicio) / CLOCKS_PER_SEC;
    printf("Tempo de insercao na arvore: %.5f segundos\n", tempo);
}

//Busca ABB retirada e adaptada dos slides da aula e dos códigos do André Backes
Palavra* busca_abb(Apontador raiz, char *chave) {
    if (raiz == NULL) return NULL;

    if (strcmp(chave, raiz->palavra.palavra) == 0) { // Se a chave for igual a raiz
        return &(raiz->palavra);
    } else if (strcmp(chave, raiz->palavra.palavra) < 0) { // Se a chave for menor que a raiz
        return busca_abb(raiz->esq, chave);                // Busca na subárvore esquerda
    } else {                                               // Se a chave for maior que a raiz
        return busca_abb(raiz->dir, chave);                // Busca na subárvore direita
    }
}

//------------------------AVL--------------------------//

int altura(No *no){
    if (no == NULL){return 0;}
    int altura_esq = altura(no->esq);
    int altura_dir = altura(no->dir);
    if (altura_esq > altura_dir){
        return altura_esq +1;
    }
    return altura_dir + 1;
}

int fator(No *no) {
    if (no == NULL){ 
        return 0;}
    return altura(no->esq) - altura(no->dir);
}

// Rotações utilizadas retiradas e adaptadas da plataforma de ensino Programiz
No* rotacao_direita(No *y) {
    No *x = y->esq;
    No *T2 = x->dir;

    x->dir = y;
    y->esq = T2;

    y->fator = fator(y);
    x->fator = fator(x);

    return x;
}

No* rotacao_esquerda(No *x) {
    No *y = x->dir;
    No *T2 = y->esq;

    y->esq = x;
    x->dir = T2;

    x->fator = fator(x);
    y->fator = fator(y);

    return y;
}

void inserir_palavra_avl(Apontador *raiz, char *palavra, int offset) {
    char palavra_modificada[50];
    int j = 0;

    for (int i = 0; palavra[i] != '\0'; i++) {
        if (eh_letra(palavra[i])) {
            palavra_modificada[j] = tolower(palavra[i]);
            j++;
        }
    }
    palavra_modificada[j] = '\0';

    if (strlen(palavra_modificada) <= 3) return;

    Palavra nova;
    strcpy(nova.palavra, palavra_modificada);
    nova.frequencia = 1;
    nova.count_offsets = 1;
    nova.offsets[0] = offset;

    inserir_avl(raiz, nova, offset); // A unica mudança da outra função de inserção
}

void adicionar_palavras_avl(Citacao citacoes[MAX_CITACOES], int total_citacoes, Apontador *raiz) {
    clock_t inicio = clock();

    for (int i = 0; i < total_citacoes; i++) {
        char *copia = malloc(strlen(citacoes[i].citacao) + 1);
        if (copia == NULL) {
            printf("Erro de alocacao de memoria.\n");
            return;
        }

        strcpy(copia, citacoes[i].citacao);
        char *separador = strtok(copia, " ");

        while (separador != NULL) {
            inserir_palavra_avl(raiz, separador, citacoes[i].offset); // A unica mudança da outra função de adicionar palavras
            separador = strtok(NULL, " ");
        }

        free(copia);
    }

    clock_t fim = clock();
    double tempo = (double)(fim - inicio) / CLOCKS_PER_SEC;
    printf("Tempo de insercao na arvore AVL: %.5f segundos\n", tempo);
}

void inserir_avl(Apontador *raiz, Palavra x, int offset) {
    if (*raiz == NULL) { // Se a árvore estiver vazia, cria um novo nó
        *raiz = criar_no(x, offset);
        return;
    } 

    if (strcmp(x.palavra, (*raiz)->palavra.palavra) < 0) { // Se a palavra for menor, insere na esquerda
        inserir_avl(&((*raiz)->esq), x, offset);

    } else if (strcmp(x.palavra, (*raiz)->palavra.palavra) > 0) { // Se a palavra for maior, insere na direita
        inserir_avl(&((*raiz)->dir), x, offset);

    } else { // Se a palavra já existir, add a frequência e adiciona o offset
        (*raiz)->palavra.frequencia++;
        (*raiz)->palavra.offsets[(*raiz)->palavra.count_offsets++] = offset;
        return;
    }

    (*raiz)->fator = fator(*raiz); // Atualiza o fator de balanceamento

    // Balanceamentos (Adaptados dos slides/exercícios da aula)
    
    if ((*raiz)->fator == 2) { //Se o fator for 2 a arvore está desbalanceada para a esquerda (E-D) => (E > D) == > 0
        if (fator((*raiz)->esq) > 0) {      // Se a subarvore esquerda for maior que a direita = Esquerda-Esquerda
            *raiz = rotacao_direita(*raiz); // Rotação simples para a direita
        } else { // Se a subarvore esquerda for menor que a direita = Esquerda-Direita
            (*raiz)->esq = rotacao_esquerda((*raiz)->esq); // Rotação dupla (ED)
            *raiz = rotacao_direita(*raiz); 
        }
    }

    if ((*raiz)->fator == -2) { //Se o fator for -2 a arvore está desbalanceada para a Direita (E-D) => (E < D) == < 0
        if (fator((*raiz)->dir) < 0) {       // Se a subarvore direita for menor que a esquerda = Direita-Direita
            *raiz = rotacao_esquerda(*raiz); // Rotação simples para a esquerda
        } else { // Se a subarvore direita for maior que a esquerda = Direita-Esquerda
            (*raiz)->dir = rotacao_direita((*raiz)->dir); // Rotação dupla (DE)
            *raiz = rotacao_esquerda(*raiz);
        }
    }
}

//----------------------FREQUENCIA---------------------------//
NoFreq* criar_no_freq(Palavra x) {
    NoFreq *novo = malloc(sizeof(NoFreq));
    if (novo == NULL) {
        printf("Erro de alocação.\n");
        exit(1);
    }

    novo->frequencia = x.frequencia;
    novo->palavras[0] = x;
    novo->count_palavras = 1;
    novo->esq = NULL;
    novo->dir = NULL;
    novo->fator = 0;
    return novo;
}
//Mesma função de altura anterior, so muda a struct
int altura_freq(NoFreq *no) {
    if (no == NULL) return 0;
    int altura_esq = altura_freq(no->esq);
    int altura_dir = altura_freq(no->dir);
    if (altura_esq > altura_dir){
        return altura_esq + 1;
    }
    return altura_dir + 1;
}

//Mesma função de fator anterior, so muda a struct
int fator_freq(NoFreq *no) {
    if (no == NULL) return 0;
    return altura_freq(no->esq) - altura_freq(no->dir);
}

//Mesmas funções de rotação anteriores, so muda a struct
NoFreq* rotacao_direita_freq(NoFreq *y) {
    NoFreq *x = y->esq;
    NoFreq *T2 = x->dir;

    x->dir = y;
    y->esq = T2;

    y->fator = fator_freq(y);
    x->fator = fator_freq(x);

    return x;
}

NoFreq* rotacao_esquerda_freq(NoFreq *x) {
    NoFreq *y = x->dir;
    NoFreq *T2 = y->esq;

    y->esq = x;
    x->dir = T2;

    x->fator = fator_freq(x);
    y->fator = fator_freq(y);

    return y;
}

void inserir_avl_freq(NoFreq **raiz, Palavra x) {
    if (*raiz == NULL) { // Se a árvore estiver vazia, cria um novo nó
        *raiz = criar_no_freq(x); 
        return;
    }

    if (x.frequencia < (*raiz)->frequencia) {        // Se a frequencia for menor que a raiz, insere na esquerda
        inserir_avl_freq(&((*raiz)->esq), x);
    } else if (x.frequencia > (*raiz)->frequencia) { // Se a frequencia for maior que a raiz, insere na direita
        inserir_avl_freq(&((*raiz)->dir), x);
    } else {                                         // Se a frequencia já existir, adiciona a palavra no vetor de palavras
        (*raiz)->palavras[(*raiz)->count_palavras++] = x;
        return;
    }

     (*raiz)->fator = fator_freq(*raiz); // Atualiza o fator de balanceamento

    // Balanceamentos
    if ((*raiz)->fator == 2) { // Se o fator for 2 a arvore está desbalanceada para a esquerda (E-D) => (E > D) == > 0
        if (fator_freq((*raiz)->esq) > 0) { // Se a subarvore esquerda for maior que a direita = Esquerda-Esquerda
            *raiz = rotacao_direita_freq(*raiz); // Rotação simples para a direita
        } else { // Se a subarvore esquerda for menor que a direita = Esquerda-Direita
            (*raiz)->esq = rotacao_esquerda_freq((*raiz)->esq); // Rotação dupla (ED)
            *raiz = rotacao_direita_freq(*raiz);
        }
    } else if ((*raiz)->fator == -2) {      // Se o fator for -2 a arvore está desbalanceada para a Direita (E-D) => (E < D) == < 0
        if (fator_freq((*raiz)->dir) < 0) { // Se a subarvore direita for menor que a esquerda = Direita-Direita
            *raiz = rotacao_esquerda_freq(*raiz); // Rotação simples para a esquerda
        } else { // Se a subarvore direita for maior que a esquerda = Direita-Esquerda
            (*raiz)->dir = rotacao_direita_freq((*raiz)->dir); // Rotação dupla (DE)
            *raiz = rotacao_esquerda_freq(*raiz);
        }
    }
}

// Basicamente, para não criar outra função de inserção, utilizamos a função padrão para inserir as palavras na AVL e depois percorremos a AVL de palavras e inserimos as palavras na AVL de frequência. A vantagem disso, além de economizar código, é que a arvore de frequência já fica ordenada em ordem alfabética.
// A função percorrer foi retirada e adaptada dos slides da aula (Percurso Central)
void percorrer_e_inserir(No *raiz_palavras, NoFreq **raiz_freq) {
    if (raiz_palavras == NULL) return;
    percorrer_e_inserir(raiz_palavras->esq, raiz_freq);
    inserir_avl_freq(raiz_freq, raiz_palavras->palavra);
    percorrer_e_inserir(raiz_palavras->dir, raiz_freq);
}

// Busca similar a busca da ABB, só muda a struct e o tipo de dado que está sendo comparado
void buscar_por_frequencia(NoFreq *raiz, int freq) {
    if (raiz == NULL) {
        printf("Nenhuma palavra com frequência %d encontrada.\n", freq);
        return;
    }

    if (freq < raiz->frequencia) {
        buscar_por_frequencia(raiz->esq, freq);
    } else if (freq > raiz->frequencia) {
        buscar_por_frequencia(raiz->dir, freq);
    } else {
        printf("\nPalavras com frequência %d (%d):\n", freq,raiz->count_palavras); // Imprime as palavras com a frequência desejada
        for (int i = 0; i < raiz->count_palavras; i++) {
            printf("- %s\n", raiz->palavras[i].palavra);
        }
    }
}

//Para imprimir as citações, utilizamos o offset da linha para buscar na struct de citações e imprimir. O problema disso é que se existirem mais de uma palavra com o mesmo offset, a citação será impressa mais de uma vez. Para resolver isso, utilizamos um método que verifica se o offset anterior é igual ao atual, se for, não imprime a citação novamente. Isso só é possivel pois o offset é único para cada linha e as linhas são inseridas em ordem.
void imprimir(Palavra *p, Citacao citacoes[], int total_citacoes) {
    if (p == NULL || p->count_offsets == 0){return;}
    int offset_anterior = -1; // -1 "didatico" para informar que é o anterior, de fato é utilizado como um valor invalido para imprimir o primeiro sem problemas.

    printf("Palavra: %s\n", p->palavra);
    printf("Frequência: %d\n", p->frequencia);
    printf("Citações:\n");

    for (int i = 0; i < p->count_offsets; i++) {
        int offset = p->offsets[i];

        if (offset != offset_anterior) { // Se o offset for diferente do anterior, imprime a citação
            offset_anterior = offset;    // Atualiza o offset anterior para o atual
            for (int j = 0; j < total_citacoes; j++) { // Percorre a struct de citações para encontrar o offset
                if (citacoes[j].offset == offset) {    // Se o offset for encontrado, imprime a citação
                    printf("\nCitação: %s\n", citacoes[j].citacao);
                    printf("Filme: %s\n", citacoes[j].filme);
                    printf("Ano: %d\n", citacoes[j].ano);
                    break;
                }
            }            
        }
    }
}

//Função para dar flush nas árvores (das 2 structs)
void free_arvore(No *raiz) { 
    if (raiz == NULL) return;
    free_arvore(raiz->esq);
    free_arvore(raiz->dir);
    free(raiz);
}
void free_arvore_freq(NoFreq *raiz) {
    if (raiz == NULL) return;
    free_arvore_freq(raiz->esq);
    free_arvore_freq(raiz->dir);
    free(raiz);
}