#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <ctype.h>
#include "Headers/Leitura.h"
#include "Headers/Arvore.h"

void Menu(){
    Citacao *citacoes = malloc(MAX_CITACOES * sizeof *citacoes);
    if (citacoes == NULL) {
        printf("Erro na alocação de memória para palavras.\n");
        free(citacoes);
        exit (1);
    }

    Palavra *palavras_vetor = malloc(MAX_PALAVRAS * sizeof(Palavra));
    if (palavras_vetor == NULL) {
        printf("Erro na alocação de memória para palavras.\n");
        free(citacoes);
        exit (1);
    }

    int total_citacoes = 0, total_palavras_vetor = 0;
    Apontador raiz_abb = NULL;
    Apontador raiz_avl = NULL;
    NoFreq *raiz_freq = NULL;


    int opcao;
    char busca[100];
    int freq;
    int arquivo_lido = 0,estrutura_criada = 0, abb = 0, avl = 0,vet = 0;
 do {
        printf("\n======= MENU =======\n");
        printf("-1. Ler arquivo (\"Movie_Quotes.csv\")\n");
        printf("1. Construir estruturas\n");
        printf("2. Buscar palavra\n");
        printf("3. Buscar por frequência\n");
        printf("0. Sair\n");
        printf("Opcao: ");
        scanf("%d", &opcao);
        getchar(); // limpar '\n'

        switch (opcao) {
            case -1: {
                if (arquivo_lido) {
                    printf("Arquivo já foi lido anteriormente.\n");
                    break;
                }

                clock_t inicio, fim;
                double tempo;

                inicio = clock();
                if (!lerArquivo("movie_quotes.csv", citacoes, &total_citacoes)) {
                    break;
                }
                fim = clock();

                tempo = (double)(fim - inicio) / CLOCKS_PER_SEC;
                printf("Arquivo lido com sucesso (%d citações).\n", total_citacoes);
                printf("Tempo de leitura: %.5lf segundos\n", tempo);

                arquivo_lido = 1;
                break;
            }

            case 1: {
                if (!arquivo_lido){
                    printf("Por favor, leia o arquivo primeiro.\n");
                    break;
                }
                printf("\nEscolha a estrutura para construir:\n");
                printf("1 - Vetor\n");
                printf("2 - ABB\n");
                printf("3 - AVL\n");
                printf("4 - Todas\n");
                printf("0 - Voltar\n");
                printf("Digite uma Opção: ");
                int esc;
                scanf("%d", &esc);
                getchar(); // limpar '\n'
                if (esc == 0) break;
                clock_t ini, fim;

                if (esc == 1 && vet) {
                    printf("Vetor já foi construído.\n");
                    break;
                }
                if (esc == 2 && abb) {
                    printf("ABB já foi construída.\n");
                    break;
                }
                if (esc == 3 && avl) {
                    printf("AVL já foi construída.\n");
                    break;
                }
                if (esc == 4 && vet && abb && avl) {
                    printf("Todas as estruturas já foram construídas.\n");
                    break;
                }

                //Usei ifs so para nao repetir codigo no caso de "Todas"
                if ((esc == 1 || esc == 4) && !vet) {
                    adicionar_palavras(citacoes, total_citacoes, palavras_vetor, &total_palavras_vetor);
                    vet = 1;
                }

                if ((esc == 2 || esc == 4) && !abb) {
                    adicionar_palavras_arvore(citacoes, total_citacoes, &raiz_abb);
                    abb = 1;
                }

                if ((esc == 3 || esc == 4) && !avl) {
                    adicionar_palavras_avl(citacoes, total_citacoes, &raiz_avl);
                    avl = 1;
                }

                estrutura_criada = 1;
                break;
            }

            case 2: {
                if (!arquivo_lido) {
                    printf("Por favor, leia o arquivo primeiro.\n");
                    break;
                }

                if (!estrutura_criada) {
                    printf("Por favor, construa uma estrutura primeiro.\n");
                    break;
                }

                printf("Digite a palavra para buscar: ");
                scanf(" %[^\n]", busca);

                for (int i = 0; busca[i] != '\0'; i++) {
                    busca[i] = tolower(busca[i]);
                }

                printf("\nBuscar em:\n");
                printf("1 - Vetor\n");
                printf("2 - ABB\n");
                printf("3 - AVL\n");
                printf("0 - Voltar\n");
                printf("Digite uma opção: ");

                int esc;
                scanf("%d", &esc);
                getchar(); // limpa '\n'

                clock_t ini = clock(), fim;

                switch (esc) {
                    case 1:
                        if (!vet) {
                            printf("Vetor ainda não foi construído.\n");
                            break;
                        }

                         else {
                            shell_sort(palavras_vetor, total_palavras_vetor);
                            int i = busca_binaria(palavras_vetor, total_palavras_vetor, busca);
                            fim = clock();
                            printf("\n[Vetor - busca binária]\n");
                            if (i != -1) {
                                imprimir(&palavras_vetor[i], citacoes, total_citacoes);
                            } else {
                                printf("Palavra não encontrada.\n");
                            }
                            printf("Tempo: %.6lf segundos\n", (double)(fim - ini) / CLOCKS_PER_SEC);
                        }
                        break;

                    case 2:
                        if (!abb) {
                            printf("ABB ainda não foi construída.\n");
                        } else {
                            Palavra *palavra_encontrada_abb = busca_abb(raiz_abb, busca);
                            fim = clock();
                            printf("\n[ABB]\n");
                            if (palavra_encontrada_abb != NULL) {
                                imprimir(palavra_encontrada_abb, citacoes, total_citacoes);
                            } else {
                                printf("Palavra não encontrada.\n");
                            }
                            printf("Tempo: %.6lf segundos\n", (double)(fim - ini) / CLOCKS_PER_SEC);
                        }
                        break;

                    case 3:
                        if (!avl) {
                            printf("AVL ainda não foi construída.\n");
                        } else {
                            Palavra *palavra_encontrada_avl = busca_abb(raiz_avl, busca);
                            fim = clock();
                            printf("\n[AVL]\n");
                            if (palavra_encontrada_avl != NULL) {
                                imprimir(palavra_encontrada_avl, citacoes, total_citacoes);
                            } else {
                                printf("Palavra não encontrada.\n");
                            }
                            printf("Tempo: %.6lf segundos\n", (double)(fim - ini) / CLOCKS_PER_SEC);
                        }
                        break;

                    case 0:
                        printf("Voltando ao menu principal...\n");
                        break;

                    default:
                        printf("Opção inválida.\n");
                        break;
                }
                break;
            }


            case 3: {
                if (!arquivo_lido){
                    printf("Por favor, leia o arquivo primeiro.\n");
                    break;
                }

                if (!avl) {
                    printf("Construindo AVL de palavras...\n");
                    adicionar_palavras_avl(citacoes, total_citacoes, &raiz_avl);
                    avl = 1;
                }

                if (raiz_freq == NULL) {
                    printf("Construindo árvore de frequência...\n");
                    clock_t ini = clock();
                    percorrer_e_inserir(raiz_avl, &raiz_freq);
                    clock_t fim = clock();
                    printf("Tempo para gerar AVL de frequência: %.5f s\n", (double)(fim - ini) / CLOCKS_PER_SEC);
                } else {
                    printf("Árvore de frequência já construída.\n");
                }

                printf("Digite a frequência para buscar: ");
                scanf("%d", &freq);
                getchar();

                buscar_por_frequencia(raiz_freq, freq);
                break;
            }

            case 0:
                printf("Saindo...\n");
                break;

            default:
                printf("Opção inválida!\n");
        }
    } while (opcao != 0);

    // Libera memória
    free_arvore(raiz_abb);
    free_arvore(raiz_avl);
    free_arvore_freq(raiz_freq);
    free(citacoes);
    free(palavras_vetor);
}

int main(){
    Menu();
}