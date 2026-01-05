#ifndef ARRAY_H
#define ARRAY_H

#define MAX_CITACOES 1000
#define MAX_PALAVRAS 2000

typedef struct {
    char citacao[512];
    char filme[100];
    int ano;
    int offset;
} Citacao;

typedef struct {
    char palavra[100];
    int frequencia;
    int offsets[MAX_CITACOES];
    int count_offsets;
} Palavra;

int eh_letra(char x);
void inserir_palavra(Palavra palavras[MAX_PALAVRAS], int *total_palavras, char *palavra, int offset);
void adicionar_palavras(Citacao citacoes[MAX_CITACOES], int total_citacoes, Palavra palavras[MAX_PALAVRAS], int *total_palavras);
void shell_sort(Palavra vetor[], int n);
int busca_binaria(Palavra palavras[], int n, const char *chave);
#endif