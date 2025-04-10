public class Classificador {
    public void ordena(Classificavel[] a) {
        Classificavel elem, menor;
        int pos;
        for (int i = 0; i < a.length - 1; i++) {
            elem = a[i];
            menor = a[i + 1];
            pos = i + 1;
            for (int j = i + 2; j < a.length; j++) {
                if (a[j].eMenorQue(menor) == 1) {
                    menor = a[j];
                    pos = j;
                }
            }

            if (menor.eMenorQue(elem) == 1) {
                a[i] = a[pos];
                a[pos] = elem;
            }
        }
    }
}