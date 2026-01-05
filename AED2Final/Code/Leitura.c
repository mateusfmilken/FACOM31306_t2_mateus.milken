#include "../Headers/Leitura.h"
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int lerArquivo(const char *nome_arquivo, Citacao citacoes[MAX_CITACOES], int *total_citacoes) {
    FILE *arquivo = fopen(nome_arquivo, "r");
    if (arquivo == NULL) {                                                // Teste erro de abertura
        printf("Erro ao abrir o arquivo!\n");
        return 0;
    }

    char linha[1024];
    int offset = 0;

    while (fgets(linha, sizeof(linha), arquivo) && *total_citacoes < MAX_CITACOES) { // Enquanto tiver linhas e < MAX
        Citacao *c = &citacoes[*total_citacoes];  
        c->offset = offset;
        char temp[1024];
        int i = 0, j = 0, campo = 0;

        while (linha[i] != '\0' && linha[i] != '\n') { // Enquanto não for fim do arquivo ou fim da linha
            if (linha[i] == '"') {                     // Se for o começo de algum campo
                i++; // Pular aspas iniciais
                j = 0;
                while (linha[i] != '"' && linha[i] != '\0') { // Enquanto nao chegar no fim da citação ou do arquivo
                    temp[j++] = linha[i++];
                }
                temp[j] = '\0'; // Finalizar string

                if (campo == 0) {
                    strcpy(c->citacao, temp); // Armazena citação
                } else if (campo == 1) {
                    strcpy(c->filme, temp);   // Armazena filme
                } else if (campo == 2) {
                    c->ano = atoi(temp);      // Converter string para inteiro e armazena ano
                }
                campo++;
            }
            i++;
        }

        (*total_citacoes)++;
        offset = ftell(arquivo); // Atualiza o offset (ftell retorna posição do ponteiro no arquivo)
    }
    fclose(arquivo);
    return 1;
}
