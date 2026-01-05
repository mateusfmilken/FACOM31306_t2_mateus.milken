#ifndef ARVORE_H
#define ARVORE_H

#include "Array.h"

typedef struct No {
    Palavra palavra;
    struct No *esq, *dir;
    int fator;
} No;

typedef No* Apontador;

typedef struct NoFreq {
    int frequencia;
    Palavra palavras[MAX_PALAVRAS];
    int count_palavras;
    struct NoFreq *esq, *dir;
    int fator;
} NoFreq;


//ABB
Apontador criar_no(Palavra x, int offset);
void Insere(Palavra x, Apontador *p, int offset);
void inserir_palavra_arvore(Apontador *raiz, char *palavra, int offset);
void adicionar_palavras_arvore(Citacao citacoes[MAX_CITACOES], int total_citacoes, Apontador *raiz);
Palavra* busca_abb(Apontador raiz, char *chave);
//AVL
int altura(No *no);
int fator(No *no);
No* rotacao_direita(No *y);
No* rotacao_esquerda(No *x);
void inserir_palavra_avl(Apontador *raiz, char *palavra, int offset);
void adicionar_palavras_avl(Citacao citacoes[MAX_CITACOES], int total_citacoes, Apontador *raiz);
void inserir_avl(Apontador *raiz, Palavra x, int offset);
// FREQ
NoFreq* criar_no_freq(Palavra x);
int altura_freq(NoFreq *no);
int fator_freq(NoFreq *no);
NoFreq* rotacao_direita_freq(NoFreq *y);
NoFreq* rotacao_esquerda_freq(NoFreq *x);
void inserir_avl_freq(NoFreq **raiz, Palavra x);
void percorrer_e_inserir(No *raiz_palavras, NoFreq **raiz_freq);
void buscar_por_frequencia(NoFreq *raiz, int freq);
void imprimir(Palavra *p, Citacao citacoes[], int total_citacoes);
void free_arvore(No *raiz);
void free_arvore_freq(NoFreq *raiz);

#endif