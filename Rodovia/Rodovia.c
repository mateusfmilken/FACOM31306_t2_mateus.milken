#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "Rodovia.h"
#define MAX_VISITADAS 100

void bras1927(Rodovia** No){ //não tinha rodovia nesse periodo ainda
      *No = NULL;
}

void novaRodo(Rodovia** No, char *rodo, float price, float veloc, float tam){ //cria rodovias
    
    Rodovia *nova;
    nova = (Rodovia*) malloc (sizeof(Rodovia));

    
if(nova == NULL){
    printf("Erro ao alocar memoria para nova rodovia\n"); // || CHECK PRA VER SE TA CERTO||
    return;
}

    strcpy(nova->nome, rodo);
    nova->preco = price;
    nova->tamanho = tam;
    nova->vel = veloc;
    nova->cities = NULL; // || PRA NAO INCIAR ERRADO ||
    nova->prox = *No;
    *No = nova;
}
/*
price = preço dos pedagios (num mundo ideal, é fixo e é menos que 100 reais)
veloc = velocidade média permitida de cada rodovia
tam = tamanho da rodovia
*/

void bras1928(Rodovia** No, char *rodo, char *city, char *state, float dist, int ped){ //busca nome da rodovia pra colocar as cidades na rodovia desejada
    Rodovia *atual;
    atual = *No;

    while (strcasecmp(atual->nome, rodo) != 0 && atual->prox != NULL) atual = atual->prox;
    if (strcasecmp(atual->nome, rodo) != 0) return;

    Estrada *novo;
    novo = (Estrada*) malloc (sizeof(Estrada));

    if (novo == NULL) { // CHECK SE DEU ERRO
        printf("Erro ao alocar memória para a estrada.\n");
        return;
    }

    strcpy(novo->cidade, city);
    strcpy(novo->estado, state);
    novo->distAnt = novo->distProx = 0;
    novo->pedagioAnt = novo->pedagioProx = 0;
    if (atual->cities != NULL){
        novo->distProx = dist;
        novo->pedagioProx = ped;
        atual->cities->distAnt = dist;
        atual->cities->pedagioAnt = ped;
    }

    if (atual->cities == NULL){
        novo->ant = NULL;
        novo->prox = NULL;
        atual->cities = novo;
    }
    else {
        novo->prox = atual->cities;
        novo->ant = NULL;
        atual->cities->ant = novo;
        atual->cities = novo;
    }
}
/*
rodo = nome rodovia
city = nome cidade
state = nome estado
dist = distancia ate prox. cidade
ped = numero de pedagios ate prox. cidade
*/

void demolirRodovia(Rodovia** No, char *rodo){ //Ja era véi, sem viagem pra você :3
    Rodovia *atual, *ante;
    int achou = 0;

    if ((*No) == NULL) return;
    else {
        atual = *No;
        ante = NULL;

        while (atual != NULL){
                if (strcasecmp(atual->nome, rodo) == 0){
                achou = 1;
                break;
            }
            else {
                ante = atual;
                atual = atual->prox;
            }
        }

        if (achou == 1){
            if (atual == *No) *No = (*No)->prox;
            else ante->prox = atual->prox;
            free(atual);
        }
        else {
            printf("Rodovia Nao Existe");
            return;
        }
    }
}

void nukarCidade(Rodovia **No, char *rodo, char *city) { // diz tchau ai pra cidade em determinada rodovia
    Rodovia *buscador;
    Estrada *atual, *ante, *proxi;
    int achou = 0;

    if (*No == NULL || (*No)->cities == NULL) return;
    else {
        buscador = *No;

        // Procurar rodovia com o nome fornecido
        while (strcasecmp(buscador->nome, rodo) != 0 && buscador->prox != NULL) 
            buscador = buscador->prox;
        if (strcasecmp(buscador->nome, rodo) != 0) {
            printf("Rodovia Nao Existe\n");
            return;
        }

        atual = buscador->cities;
        ante = proxi = NULL;

        // Procurar cidade na lista da rodovia
        while (atual != NULL) {
            if (strcasecmp(atual->cidade, city) == 0) {
                achou = 1;
                break;
            } else {
                ante = atual;
                atual = atual->prox;
                if (atual != NULL) {
                    proxi = atual->prox; // Atualiza proxi se atual não for NULL
                }
            }
        }

        if (achou == 1) {
            // Caso em que a cidade é o primeiro nó da lista
            if (atual == buscador->cities) { 
                buscador->cities = atual->prox;
                if (buscador->cities != NULL) {
                    buscador->cities->distAnt = 0;
                    buscador->cities->pedagioAnt = 0;
                    buscador->cities->ant = NULL;
                }
            } 
            // Caso em que a cidade é o último nó da lista
            else if (atual->prox == NULL) { 
                ante->prox = NULL;
                ante->distProx = 0;
                ante->pedagioProx = 0;
            } 
            // Caso em que a cidade está no meio da lista
            else { 
                ante->prox = atual->prox;
                proxi->ant = atual->ant;
                ante->distProx = atual->distAnt + atual->distProx;
                proxi->distAnt = ante->distProx;
                ante->pedagioProx = atual->pedagioAnt + atual->pedagioProx;
                proxi->pedagioAnt = ante->pedagioProx;
            }
            free(atual); // Libera a memória da cidade removida
        } else {
            printf("Cidade Nao Existe\n");
            return;
        }
    }
}

void printSofisticado(Rodovia *No){
    Rodovia* rodo;
    Estrada* city;
    rodo = No;

    while (rodo != NULL){
        printf("\n\n|%-10s%-22s%5.2f%-2s%-16s", rodo->nome, "Preco dos Pedagios: RS", rodo->preco, ".", "Vel. Permitida:");
        printf("%7.2f%-6s%-20s%7.2f%-2s%3s\n", rodo->vel, "Km/h.", "Tamanho da Rodovia:", rodo->tamanho, "Km", "|");
        city = rodo->cities;
        
        printf("|%-28s|%-10s|%-13s|", "Cidades:", "Estados:", "Dist Ante:");
        printf("%-13s|%-15s|%-15s|\n", "Dist Prox:", "Pedagios Ante:", "Pedagios Prox:");
        
        while (city != NULL){
            printf("|%-28s|%-10s|%7.2f%-6s|", city->cidade, city->estado, city->distAnt, "Km");
            printf("%7.2f%-6s|%-15d|%-15d|\n", city->distProx, "Km", city->pedagioAnt, city->pedagioProx);
            city = city->prox;
        }
        rodo = rodo->prox;
    }
}

void printRodo(Rodovia *No, char *nomeRodovia) {
    Rodovia *rodo = No;
    Estrada *city;

    // Procura a rodovia 
    while (rodo != NULL && strcasecmp(rodo->nome, nomeRodovia) != 0) {
        rodo = rodo->prox;
    }

    // Verifica se a rodovia foi encontrada
    if (rodo == NULL) {
        printf("Rodovia %s não encontrada.\n", nomeRodovia);
        return;
    }

    
printf("\n\n|%-10s%-22s%5.2f%-2s%-16s", rodo->nome, "Preco dos Pedagios: RS", rodo->preco, ".", "Vel. Permitida:");
printf("%7.2f%-6s%-20s%7.2f%-2s%3s\n", rodo->vel, "Km/h.", "Tamanho da Rodovia:", rodo->tamanho, "Km", "|");
city = rodo->cities;

printf("|%-28s|%-10s|%-13s|", "Cidades:", "Estados:", "Dist Ante:");
printf("%-13s|%-15s|%-15s|\n", "Dist Prox:", "Pedagios Ante:", "Pedagios Prox:");

while (city != NULL){
    printf("|%-28s|%-10s|%7.2f%-6s|", city->cidade, city->estado, city->distAnt, "Km");
    printf("%7.2f%-6s|%-15d|%-15d|\n", city->distProx, "Km", city->pedagioAnt, city->pedagioProx);
    city = city->prox;
}}

void lerRodovias(Rodovia** rodovias, char *arq){
 FILE* file = fopen(arq,"r");
    if (file == NULL){
        printf("Erro ao abrir o arquivo.\n");
        return;
    }


char linha[100];
    char nomeRodovia[10]; char cidade [40]; char estado[10]; 
int dist, pedagio, veloc, tam;
float price;

Rodovia *rodoAtual;

while (fgets(linha,sizeof(linha),file)){

linha[strcspn(linha, "\n")] = '\0'; // Correção para tirar o /n que o Fgets adiciona;
    
if (strncmp(linha, "BR-", 3) == 0) {
    strcpy(nomeRodovia, linha);

   
    fgets(linha, sizeof(linha), file); // Pega o preço do pedagio
    price = strtof(linha, NULL); // Isso transforma a string para um float

    fgets(linha, sizeof(linha), file); // Pega a Velocidade Media da Pista
    veloc = strtof(linha, NULL); // Isso transforma a string para um float

    fgets(linha, sizeof(linha), file); // Pega o Tamanho da Rodovia
    tam = strtof(linha, NULL);  // Isso transforma a string para um float
    
    novaRodo(rodovias, nomeRodovia, price, veloc, tam);
    rodoAtual = *rodovias;
}
 else if (rodoAtual != NULL) {
    strcpy(cidade, linha);  
    fgets(linha, sizeof(linha), file); 
     
    linha[strcspn(linha, "\n")] = '\0';
    strcpy(estado, linha);

     fgets(linha, sizeof(linha), file); // Pega a distância;
     dist = strtol(linha, NULL, 10);    // Isso transforma a string para um float

     fgets(linha, sizeof(linha), file); // Pega o nmr de pedagios
     pedagio = strtol(linha, NULL, 10); // Isso transforma a string para um float


     bras1928(rodovias, rodoAtual->nome, cidade, estado, dist, pedagio);
}
    
}
    fclose(file);
} 

int mesmaRodovia(Rodovia *No, char *city1, char *city2) {
        int encontrou = 0;  
        int cidade1Existe = 0, cidade2Existe = 0; 
        Rodovia *rodo = No;

        // Primeiro, verifica se a city1 existe em alguma rodovia
        while (rodo != NULL) {
            Estrada *road = rodo->cities;

            while (road != NULL) {
                if (strcmp(city1, road->cidade) == 0) {
                    cidade1Existe = 1;  // Marca que city1 foi encontrada
                    break;
                }
                road = road->prox;
            }

            if (cidade1Existe) break;  // Se encontrou city1, sai da busca pela city1

            rodo = rodo->prox;
        }

        if (!cidade1Existe) {
            //printf("A cidade %s não foi encontrada em nenhuma rodovia.\n", city1);
            return 0;  // Se city1 não existir, retorna 0 e não continua
        }

        // Agora, verifica se a city2 existe em alguma rodovia
        rodo = No;  // Reseta para a primeira rodovia
        while (rodo != NULL) {
            Estrada *road = rodo->cities;

            while (road != NULL) {
                if (strcmp(city2, road->cidade) == 0) {
                    cidade2Existe = 1;  // Marca que city2 foi encontrada
                    break;
                }
                road = road->prox;
            }

            if (cidade2Existe) break;  // Se encontrou city2, sai da busca pela city2

            rodo = rodo->prox;
        }

        if (!cidade2Existe) {
            //printf("A cidade %s não foi encontrada em nenhuma rodovia.\n", city2);
            return 0;  // Se city2 não existir, retorna 0 e não continua
        }

        // Agora, se as duas cidades existem, verifica se estão na mesma rodovia
        rodo = No;  // Reseta para a primeira rodovia
        while (rodo != NULL) {
            Estrada *road = rodo->cities;
            int achou1 = 0, achou2 = 0;

            while (road != NULL) {
                if (strcmp(city1, road->cidade) == 0) {
                    achou1 = 1;  // Encontrou city1
                }
                if (strcmp(city2, road->cidade) == 0) {
                    achou2 = 1;  // Encontrou city2
                }

                if (achou1 && achou2) {
                    //printf("As cidades %s e %s estão na rodovia %s.\n", city1, city2, rodo->nome);
                    encontrou = 1;
                    break;
                }

                road = road->prox;
            }

            if (encontrou) break;  // Se encontrou, sai da busca

            rodo = rodo->prox;
        }

        // Se as cidades não estiverem na mesma rodovia
        if (!encontrou) {
            //printf("As cidades %s e %s não estão nenhuma rodovia em comum.\n", city1, city2);
        }

        return encontrou;
    }

void exibirMenu() {


        // Menu de opções
        printf("\n===========================================\n");
        printf("||             MENU DE OPÇÕES             ||\n");
        printf("|| -1. Ler Arquivo Teste das Rodovias     ||\n");
        printf("|| 1. Ler Arquivo das Rodovias            ||\n");
        printf("|| 2. Inserir Rodovia                     ||\n");
        printf("|| 3. Inserir Cidade em Rodovia           ||\n");
        printf("|| 4. Mostrar Rodovia                     ||\n");
        printf("|| 5. Mostrar todas as Rodovias e Cidades ||\n");
        printf("|| 6. Verificar Cruzamento entre Rodovias ||\n");
        printf("|| 7. Remover Rodovia                     ||\n");
        printf("|| 8. Remover Cidade                      ||\n");
        printf("|| 9. Achar Rota                          ||\n");
        printf("|| 0. Sair                                ||");
        printf("\n===========================================\n");
    }

int cidadeExiste(Rodovia *No, char *estado, char *cidade, char *rodo){
        Rodovia *auxR;
        Estrada *auxC;
        auxR = No;

        if (auxR->cities == NULL) return 0;  // Se não tem cidades na rodovia

        do {
            if (strcasecmp(rodo, auxR->nome) == 0){  // Verifica se rodovia existe
                auxC = auxR->cities;
                do {
                    if (strcasecmp(cidade, auxC->cidade) == 0 && strcasecmp(estado, auxC->estado) == 0){  // Compara cidade e estado
                        return 1;  // Cidade encontrada
                    }
                    auxC = auxC->prox;
                } while (auxC != NULL);
                return 0;  // Cidade não encontrada na rodovia
            }
            auxR = auxR->prox;
        } while (auxR != NULL);

        return 0;  // Rodovia não encontrada
    }

int cidadeExisteTodas(Rodovia *No, char *estado, char *cidade){
        Rodovia *auxR = No;
        Estrada *auxC;

        
        while (auxR != NULL) {
            // Verifica se a rodovia tem cidades
            if (auxR->cities != NULL) {
                auxC = auxR->cities;
                // Percorre todas as cidades da rodovia
                while (auxC != NULL) {
                    
                    if (strcasecmp(cidade, auxC->cidade) == 0 && strcasecmp(estado, auxC->estado) == 0) {
                        return 1;  // Cidade encontrada
                    }
                    auxC = auxC->prox;
                }
            }
            auxR = auxR->prox;
        }

        return 0;  // Cidade não encontrada em nenhuma rodovia
    }

int rodoviaExiste(Rodovia *No, char *rodo){
    Rodovia *auxR;
    auxR = No;

    if (auxR == NULL) return 0;  

    do {
        if (strcasecmp(rodo, auxR->nome) == 0){  // Verifica se rodovia existe
            return 1;  // Rodovia encontrada
        }
        auxR = auxR->prox;
    } while (auxR != NULL);

    return 0;  // Rodovia não encontrada
}

int cruzamento(Rodovia *No, char *state, char *city, char *rodo1, char *rodo2) { 
    // Verifica se duas rodovias passam por uma mesma cidade
    int achou1, achou2;
    achou1 = achou2 = 0;
    Rodovia *auxR1 = No, *auxR2 = No;
    Estrada *auxC1, *auxC2;

    if (auxR1->cities == NULL || auxR2->cities == NULL) return 0;

    while (auxR1 != NULL) {
        if (strcasecmp(rodo1, auxR1->nome) == 0) {
            auxC1 = auxR1->cities;
            while (auxC1 != NULL) {
                if (strcasecmp(city, auxC1->cidade) == 0 && strcasecmp(state, auxC1->estado) == 0) {
                    achou1 = 1;
                    break;
                }
                auxC1 = auxC1->prox;
            }
        }
        auxR1 = auxR1->prox;
    }

    while (auxR2 != NULL) {
        if (strcasecmp(rodo2, auxR2->nome) == 0) {
            auxC2 = auxR2->cities;
            while (auxC2 != NULL) {
                if (strcasecmp(city, auxC2->cidade) == 0 && strcasecmp(state, auxC2->estado) == 0) {
                    achou2 = 1;
                    break;
                }
                auxC2 = auxC2->prox;
            }
        }
        auxR2 = auxR2->prox;
    }

    return (achou1 && achou2);
}

void percurso(Rodovia *No, char *city1, char *city2, float *dist, float *valor) {
    Rodovia *rodo1, *rodo2;
    Estrada *road1, *road2, *aux;
    char save1[10];
    char save2[10];
    int achou1 = 0, achou2 = 0, cruzamento_encontrado = 0;

    rodo1 = rodo2 = No;

    // Identifica a rodovia em que cada cidade está
    while (rodo1 != NULL) {
        road1 = rodo1->cities;
        while (road1 != NULL) {
            if (strcasecmp(city1, road1->cidade) == 0) achou1 = 1;
            else if (strcasecmp(city2, road1->cidade) == 0) achou2 = 1;
            if (achou1 && achou2) break;
            road1 = road1->prox;
        }
        if (achou1 && achou2) break; // Cidades na mesma rodovia
        if (achou1) strcpy(save1, rodo1->nome); // Armazena a rodovia de city1
        if (achou2) strcpy(save2, rodo1->nome); // Armazena a rodovia de city2
        rodo1 = rodo1->prox;
        achou1 = achou2 = 0;
    }

    if (achou1 && achou2) {
        // Se as cidades estão na mesma rodovia, executa o percurso direto
        if (strcasecmp(road1->cidade, city1) == 0) {
            // Imprime o caminho
            printf("Caminho direto de %s para %s: \n\n", city1, city2);
            do {
                printf("%s", road1->cidade);
                *valor += (road1->pedagioAnt * rodo1->preco);
                *dist += road1->distAnt;
                road1 = road1->ant;
                if (strcasecmp(city2, road1->cidade) != 0) printf(" -> ");
                if (strcasecmp(city2, road1->cidade) == 0) printf(" -> %s", road1->cidade);
            } while (strcasecmp(city2, road1->cidade) != 0);
        } else if (strcasecmp(road1->cidade, city2) == 0) {
            while (strcasecmp(road1->cidade, city1) != 0) road1 = road1->ant;
            // Imprime o caminho
            printf("Caminho direto de %s para %s: \n\n", city2, city1);
            do {
                printf("%s", road1->cidade);
                *valor += (road1->pedagioProx * rodo1->preco);
                *dist += road1->distProx;
                road1 = road1->prox;
                if (strcasecmp(city2, road1->cidade) != 0) printf(" -> ");
                if (strcasecmp(city2, road1->cidade) == 0) printf(" -> %s", road1->cidade);
            } while (strcasecmp(city2, road1->cidade) != 0);
        }
        printf("\nDistância total: %.2f km\n", *dist);
        printf("Valor total dos pedágios: R$ %.2f\n", *valor);
    } else {
        // Caso as cidades estejam em rodovias diferentes
        Rodovia *cruza_rodo1 = No;
        Estrada *cidade_intermediaria = NULL;
        float dist_parcial = 0, valor_parcial = 0;

        // Procura por uma cidade intermediária (cruzamento) entre as duas rodovias
        while (cruza_rodo1 != NULL && !cruzamento_encontrado) {
            road1 = cruza_rodo1->cities;
            while (road1 != NULL && !cruzamento_encontrado) {
                if (cruzamento(No, road1->estado, road1->cidade, save1, save2)) {
                    cidade_intermediaria = road1;
                    cruzamento_encontrado = 1;
                }
                road1 = road1->prox;
            }
            cruza_rodo1 = cruza_rodo1->prox;
        }

        if (cruzamento_encontrado) {
            // Percurso da city1 até a cidade intermediária
            printf("Percurso até a cidade intermediária:\n\n");
            percurso(No, city1, cidade_intermediaria->cidade, &dist_parcial, &valor_parcial);

            // Atualizar distâncias e valores após o primeiro percurso
            *dist += dist_parcial;
            *valor += valor_parcial;

            // Percurso da cidade intermediária até o city2
            dist_parcial = 0;
            valor_parcial = 0;
            printf("\nPercurso da cidade intermediária até o destino:\n\n");
            percurso(No, cidade_intermediaria->cidade, city2, &dist_parcial, &valor_parcial);

            *dist += dist_parcial;
            *valor += valor_parcial;

            printf("\nDistância total: %.2f km\n", *dist);
            printf("Valor total dos pedágios: R$ %.2f\n", *valor);
        } else {
            printf("Nenhum cruzamento encontrado entre %s e %s.\n", save1, save2);
        }
    }
}
