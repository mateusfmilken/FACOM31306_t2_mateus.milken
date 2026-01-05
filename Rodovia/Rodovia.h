struct estrada{
    char cidade[30];
    char estado[4];
    float distProx; //distancia ate a proxima cidade
    float distAnt; //dist. ate a cidade anterior
    int pedagioProx; //Num. de pedagios ate a prox. cidade
    int pedagioAnt; //Num. de ped. até a cidade ant.
    struct estrada *ant;
    struct estrada *prox;
};
typedef struct estrada Estrada;

struct rodovia{
    char nome[10];
    float preco;
    float vel;
    float tamanho;
    Estrada *cities; //cidades conectadas pela rodovia
    struct rodovia *prox;
};
typedef struct rodovia Rodovia;


void bras1927(Rodovia** No);
void novaRodo(Rodovia** No, char *rodo, float price, float veloc, float tam);
void bras1928(Rodovia** No, char *rodo, char *city, char *state, float dist, int ped);
void demolirRodovia(Rodovia** No, char *rodo);
void nukarCidade(Rodovia **No, char *rodo, char *city);
void printSofisticado(Rodovia *No);
void printRodo(Rodovia *No, char *nomeRodovia);
void lerRodovias(Rodovia** rodovias, char *arq);
int mesmaRodovia(Rodovia *No, char *city1, char *city2);
void exibirMenu();
int cidadeExiste(Rodovia *No, char *estado, char *cidade, char *rodo);
int cidadeExisteTodas(Rodovia *No, char *estado, char *cidade);
int rodoviaExiste(Rodovia *No, char *rodo);
int cruzamento(Rodovia *No, char *state, char *city, char *rodo1, char *rodo2);
void percurso(Rodovia *No, char *city1, char *city2, float *dist, float *valor);













