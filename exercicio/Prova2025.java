public class Prova2025 {

    // ================= FUNÇÃO AUXILIAR =================
    public static boolean existe(int[] v, int tam, int valor) {
        for (int i = 0; i < tam; i += 1) {
            if (v[i] == valor) {
                return true;
            }
        }
        return false;
    }

    // ================= QUESTÃO A - UNIÃO =================
    public static int uniao(int[] a, int tamA, int[] b, int tamB,
         int[] u) {
        int tamU = 0;

        for (int i = 0; i < tamA; i += 1) {
            if (!existe(u, tamU, a[i])) {
                u[tamU] = a[i];
                tamU += 1;
            }
        }

        for (int i = 0; i < tamB; i += 1) {
            if (!existe(u, tamU, b[i])) {
                u[tamU] = b[i];
                tamU += 1;
            }
        }

        return tamU;
    }

    // ================= QUESTÃO B - ORDENAR =================
    public static void ordenar(int[] v, int n) {
        for (int i = 1; i < n; i += 1) {
            int chave = v[i];
            int j = i - 1;

            while (j >= 0 && v[j] > chave) {
                v[j + 1] = v[j];
                j -= 1;
            }

            v[j + 1] = chave;
        }
    }

    // ================= QUESTÃO C - SEM REPETIÇÃO =================
    public static int gerarVetorSemRepeticao(int[] v, int tamV, int[] vsr) {
        int tamVSR = 0;

        for (int i = 0; i < tamV; i += 1) {
            if (!existe(vsr, tamVSR, v[i])) {
                vsr[tamVSR] = v[i];
                tamVSR += 1;
            }
        }

        return tamVSR;
    }

    // ================= QUESTÃO D - ROTAÇÃO =================
    public static void rotacionar(int[] v, int tam, int k) {
        if (k < 0) {
            k = tam + k;
        }

        for (int r = 0; r < k; r += 1) {
            int primeiro = v[0];

            for (int i = 0; i < tam - 1; i += 1) {
                v[i] = v[i + 1];
            }

            v[tam - 1] = primeiro;
        }
    }
}