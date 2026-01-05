#include "../Headers/Array.h"
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>
#include <time.h>

int eh_letra(char x) {
  return (x >= 'a' && x <= 'z') || (x >= 'A' && x <= 'Z');
}

void inserir_palavra(Palavra palavras[MAX_PALAVRAS], int *total_palavras, char *palavra, int offset) {
  char palavra_modificada[100];
  int j = 0;

  // Remover caracteres que não são letras
  for (int i = 0; palavra[i] != '\0'; i++) {
      if (eh_letra(palavra[i])) {
          palavra_modificada[j] = tolower(palavra[i]);  // Converte tudo para minúscula
          j++;
      }
  }
  palavra_modificada[j] = '\0';                         // Indica que a palavra acabou

  if (strlen(palavra_modificada) <= 3) return;          // Se a palavra tiver menos de 3 caracteres, retorna

  for (int i = 0; i < *total_palavras; i++) {
      if (strcmp(palavra_modificada, palavras[i].palavra) == 0) { // Se palavra repetida
          palavras[i].frequencia++;                               // Incrementa a frequência   
          palavras[i].offsets[palavras[i].count_offsets++] = offset; // Adiciona o offset
          return;
      }
  }
  // Se não for repetida, insere a nova palavra
  strcpy(palavras[*total_palavras].palavra, palavra_modificada); // Copia a palavra modificada para a struct
  palavras[*total_palavras].frequencia = 1;                      // Inicia a frequência
  palavras[*total_palavras].offsets[0] = offset;                 // Insere o offset
  palavras[*total_palavras].count_offsets = 1;                   // Inicia o counter
  (*total_palavras)++;
}

void adicionar_palavras(Citacao citacoes[MAX_CITACOES], int total_citacoes, Palavra palavras[MAX_PALAVRAS], int *total_palavras) {
  clock_t inicio, fim;  
  double tempo;

  inicio = clock();

  for (int i = 0; i < total_citacoes; i++) {
      char *copia = malloc(strlen(citacoes[i].citacao) + 1); // +1 para o \0
      if (copia == NULL) {
          printf("Erro de alocação de memória.\n"); // Teste erro alocação
          return;
      }

      strcpy(copia, citacoes[i].citacao);   // Copia a citação
      char *separador = strtok(copia, " "); // Separa a citação em palavras pelos espaços

      while (separador != NULL) {
          inserir_palavra(palavras, total_palavras, separador, citacoes[i].offset);
          separador = strtok(NULL, " "); // continua de onde parou
      }

      free(copia);
  }
  fim = clock();
  tempo = (double)(fim - inicio) / CLOCKS_PER_SEC;

      printf("Tempo de inserção no vetor: %.5f segundos\n", tempo);
}

//Shell sort retirado e adaptado dos slides da aula
void shell_sort(Palavra vetor[], int n) { 
  int i, j, h = 1;
  Palavra aux;
  do {
      h = h * 3 + 1;
  } while (h < n);

  do {
      h /= 3;
      for (i = h; i < n; i++) {
          aux = vetor[i];
          j = i;
          while (strcmp(vetor[j - h].palavra, aux.palavra) > 0) {
              vetor[j] = vetor[j - h];
              j -= h;
              if (j < h) break;
          }
          vetor[j] = aux;
      }
  } while (h != 1);
}

//Busca Binaria retirada e adaptada dos slides da aula
int busca_binaria(Palavra palavras[], int n, const char *chave) {
  int inf = 0, sup = n - 1, meio;
  while (inf <= sup) {
      meio = (inf + sup) / 2;
      if (strcmp(palavras[meio].palavra, chave) == 0)
          return meio;
      else if (strcmp(palavras[meio].palavra, chave) > 0)
          sup = meio - 1;
      else
          inf = meio + 1;
  }
  return -1;
}
