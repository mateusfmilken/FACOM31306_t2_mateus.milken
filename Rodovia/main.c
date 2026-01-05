#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "Rodovia.h"

int main() {

    int opcao;
    int ped;
    int contador0 = 0, contador1 =0;
    float preco, veloc, tam, dist;
    char rodo[8], rodo2[8], cid[30], cid2[30], est[5], est2[5],caminho[100];
    Rodovia* rodovias = NULL;


printf("\n============================================================================\n");
    printf("                               MENU DE OPÇÕES              \n");
    printf("============================================================================\n");
    printf("                       ____________________                               \n");
    printf("                     //|           |        \\                             \n");
    printf("                   //  |           |          \\                           \n");
    printf("      ___________//____|___________|__________()\\__________________      \n");
    printf("    /__________________|_=_________|_=___________|_________________{}    \n");
    printf("    [           ______ |           | .           | ==  ______      { }   \n");
    printf("  __[__        /##  ##\\|           |             |    /##  ##\\    _{# }_ \n");
    printf(" {_____)______|##    ##|___________|_____________|___|##    ##|__(______} \n");
    printf("             /  ##__##                              /  ##__##        \\    \n");
    printf("\n============================================================================\n");
    do {
        exibirMenu();
        printf("Escolha uma opção: ");
        scanf("%d", &opcao);
        
        switch (opcao) {       
            case -1:
                if(contador0 == 1){ printf("Arquivo ja lido\n"); break;}
            lerRodovias(&rodovias, "arq2.txt");
            printf("Arquivo teste lido com sucesso!\n");
                contador0 = 1;
            break;
            
            case 1:
                if(contador1 == 1){ printf("Arquivo ja lido\n"); break;}
                lerRodovias(&rodovias, "arq.txt");
                printf("Arquivo lido com sucesso!\n");
                contador1 = 1;
                break;

            case 2:
                printf("Nome da rodovia: ");
                scanf("%s", rodo);
                if (rodoviaExiste(rodovias, rodo)) {
                    printf("Rodovia '%s' já existe. Não será adicionada novamente.\n", rodo);
                    break;
                }
                printf("Preço do pedagio: ");
                scanf("%f", &preco);
                printf("Velocidade máxima: ");
                scanf("%f", &veloc);
                printf("Tamanho da rodovia: ");
                scanf("%f", &tam);
                novaRodo(&rodovias, rodo, preco, veloc, tam);
                break;

            case 3:
                printf("Nome da rodovia: ");
                scanf("%s", rodo);
                if (rodoviaExiste(rodovias, rodo) == 0) {
                    printf("Rodovia não encontrada.\n");
                    break;
                }
                printf("Nome da cidade: ");
                getchar(); //limpa o buffer
                fgets(cid, sizeof(cid), stdin);
                cid[strcspn(cid, "\n")] = 0; // Remove o \n do final
                printf("Estado: ");
                scanf("%s", est);
                printf("Distância até a próxima cidade: ");
                scanf("%f", &dist);
                printf("Número de pedágios até a próxima cidade: ");
                scanf("%d", &ped);
                bras1928(&rodovias, rodo, cid, est, dist, ped);
                break;

            case 4:
                printf("Nome da rodovia: ");
                scanf("%s", rodo);
                if (rodoviaExiste(rodovias, rodo) == 0) {
                    printf("Rodovia não encontrada.\n");
                    break;
                }
                printf("\nRodovia encontrada: ");
                printRodo(rodovias, rodo);
                break;

            case 5:
                if(rodovias == NULL) {printf("\nNão existem rodovias"); break;}
                printSofisticado(rodovias);
                break;

            case 6:
                printf("Digite o nome da Primeira Rodovia: ");
                scanf("%s", rodo);
                if (rodoviaExiste(rodovias, rodo) == 0) {
                    printf("Rodovia não encontrada.\n");
                    break;
                }
                printf("Digite o nome da Segunda Rodovia: ");
                scanf("%s", rodo2);
                if (rodoviaExiste(rodovias, rodo2) == 0) {
                    printf("Rodovia não encontrada.\n");
                    break;
                }
                printf("Digite o Nome da Cidade: ");
                getchar();
                fgets(cid, sizeof(cid), stdin);
                cid[strcspn(cid, "\n")] = 0; // Remove o \n do final
                printf("Digite o Estado (Sigla): ");
                scanf("%s", est);
                if (cidadeExiste(rodovias, est, cid, rodo) == 0) {
                    printf("Cidade não existe.\n");
                    break;
                }

                int resultado = cruzamento(rodovias, est, cid, rodo, rodo2);

                if (resultado) {
                    printf("As rodovias %s e %s cruzam na cidade %s(%s).\n", rodo, rodo2, cid, est);
                } else {
                    printf("As rodovias %s e %s não cruzam na cidade %s(%s).\n", rodo, rodo2, cid, est);
                }
                break;

            case 7:
                printf("Nome da rodovia a remover: ");
                scanf("%s", rodo);
                if (rodoviaExiste(rodovias, rodo) == 0) {
                    printf("Rodovia não encontrada.\n");
                    break;
                }
                printf("Demolindo Rodovia %s...\n", rodo);
                demolirRodovia(&rodovias, rodo);
                break;

            case 8:
                printf("Nome da rodovia: ");
                scanf("%s", rodo);
                if (rodoviaExiste(rodovias, rodo) == 0) {
                    printf("Rodovia não encontrada.\n");
                    break;
                }
                printf("Nome da cidade a remover: ");
                getchar();
                fgets(cid, sizeof(cid), stdin);
                cid[strcspn(cid, "\n")] = 0; // Remove o \n do final
                printf("Estado da cidade a remover: ");
                scanf("%s", est);
                if (cidadeExiste(rodovias, est, cid, rodo) == 0) {
                    printf("Cidade não existe.\n");
                    break;
                }

                printf("\nRemovendo Cidade %s(%s) da rodovia %s...\n", cid, est, rodo);
                nukarCidade(&rodovias, rodo, cid);
                printf("\nRodovia Atualizada: ");
                printRodo(rodovias, rodo);
                break;

            case 9:
                
                printf("Digite o Nome da Cidade de Origem: ");
                getchar(); //limpa o buffer
                fgets(cid, sizeof(cid), stdin);
                cid[strcspn(cid, "\n")] = 0; // Remove o \n do final
                printf("Digite o Estado (Sigla): ");
                scanf("%s", est);
                if (cidadeExisteTodas(rodovias, est, cid) == 0) {
                    printf("Cidade não existe.\n");
                    break;
                }
                printf("Digite o Nome da Cidade de Destino: ");
                getchar();
                fgets(cid2, sizeof(cid2), stdin);
                cid2[strcspn(cid2, "\n")] = 0; // Remove o \n do final
                printf("Digite o Estado (Sigla): ");
                scanf("%s", est2);
                if (cidadeExisteTodas(rodovias, est2, cid2) == 0) {
                    printf("Cidade não existe.\n");
                    break;
                }
                printf("\nIniciando Percurso entre %s(%s) e %s(%s):\n\n", cid, est, cid2, est2);
                printf("                                                         _________________________    \n");
                printf("                    /\\       _____          _____       |   |     |     |    | |  \\  \n");
                printf("     ,-----,       /  \\\\____/__|__\\_    ___/__|__\\___   |___|_____|_____|____|_|___\\ \n");
                printf("  ,--'---:---`--, /  |  _     |     `| |      |      `| |                    | |    \\ \n");
                printf(" ==(o)-----(o)==J    `(o)-------(o)=   `(o)------(o)'   `--(o)(o)--------------(o)--'  \n");
                printf("`````````````````````````````````````````````````````````````````````````````````````\n\n\n");
                float dist = 0.0, preco = 0.0;
                percurso(rodovias, cid, cid2, &dist, &preco);
                break;

            case 0:
                printf("\nSaindo do Programa...");
                return 0;

            default:
                printf("Opção inválida! Tente novamente.\n");
                break;
        }
    } while (opcao != 0);

    return 0;
}


