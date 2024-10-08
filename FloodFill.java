

import java.awt.Color;
import java.awt.image.BufferedImage;

public class FloodFill {

    public static void floodFillPilha(BufferedImage img, int x, int y, Color novaCor, FloodFillPanel painel) {
        Pilha<int[]> stack = new Pilha<>(1000000);
        Color corOriginal = new Color(img.getRGB(x, y));
        stack.empilhar(new int[]{x, y});
        
        int contador = 0;

        while (!stack.estaVazia()) {
            int[] pos = stack.desempilhar();
            int px = pos[0];
            int py = pos[1];

            if (estaDentro(img, px, py) && new Color(img.getRGB(px, py)).equals(corOriginal)) {
                img.setRGB(px, py, novaCor.getRGB());

                contador++;
                if (contador % 1000 == 0) {
                    atualizarTela(painel, img);
                }

                stack.empilhar(new int[]{px + 1, py});
                stack.empilhar(new int[]{px - 1, py});
                stack.empilhar(new int[]{px, py + 1});
                stack.empilhar(new int[]{px, py - 1});
            }
        }

        atualizarTela(painel, img);
    }

    public static void floodFillFila(BufferedImage img, int x, int y, Color novaCor, FloodFillPanel painel) {
        Fila<int[]> fila = new Fila<>(10000); 
        Color corOriginal = new Color(img.getRGB(x, y));
        fila.enfileirar(new int[]{x, y});
        
        int contador = 0;

        while (!fila.estaVazia()) {
            int[] pos = fila.desenfileirar();
            int px = pos[0];
            int py = pos[1];

            if (estaDentro(img, px, py) && new Color(img.getRGB(px, py)).equals(corOriginal)) {
                img.setRGB(px, py, novaCor.getRGB());

                contador++;
                if (contador % 1000 == 0) {
                    atualizarTela(painel, img);
                }

                fila.enfileirar(new int[]{px + 1, py});
                fila.enfileirar(new int[]{px - 1, py});
                fila.enfileirar(new int[]{px, py + 1});
                fila.enfileirar(new int[]{px, py - 1});
            }
        }

        atualizarTela(painel, img);
    }

    private static boolean estaDentro(BufferedImage img, int x, int y) {
        return x >= 0 && y >= 0 && x < img.getWidth() && y < img.getHeight();
    }

    private static void atualizarTela(FloodFillPanel painel, BufferedImage img) {
        painel.atualizarImagem(img);
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
