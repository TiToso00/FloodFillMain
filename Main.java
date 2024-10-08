import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        try {
            String caminhoArquivo = "E:\\www\\FloodFill\\Imagem.jpg";

            BufferedImage imagemBase = ImageIO.read(new File(caminhoArquivo));

            BufferedImage imagemProcessada = duplicarImagem(imagemBase);

            FloodFillPanel painel = new FloodFillPanel(imagemProcessada);

            JFrame janela = new JFrame("Animação Flood Fill");

            janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            janela.getContentPane().add(painel);

            janela.setSize(imagemProcessada.getWidth(), imagemProcessada.getHeight());

            janela.setVisible(true);

            int xInicial = 250;
            int yInicial = 250;

            Color corNova = new Color(0, 255, 0);

            String[] opcoes = {"Pilha", "Fila"};

            String escolha = (String) JOptionPane.showInputDialog(
                    janela,
                    "Escolha o método de Flood Fill:",
                    "Opção de Implementação",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    opcoes,
                    opcoes[0]
            );

            if (escolha != null) {
                if (escolha.equals("Pilha")) {
                    FloodFill.floodFillPilha(imagemProcessada, xInicial, yInicial, corNova, painel);
                } else if (escolha.equals("Fila")) {
                    imagemProcessada = duplicarImagem(imagemBase);
                    FloodFill.floodFillFila(imagemProcessada, xInicial, yInicial, corNova, painel);
                }

                JOptionPane.showMessageDialog(
                        janela,
                        "Flood Fill finalizado e imagem salva com sucesso!",
                        "Concluído",
                        JOptionPane.INFORMATION_MESSAGE
                );
            } else {
                System.out.println("Nenhuma opção foi selecionada. Programa encerrado.");
            }

        } catch (IOException e) {
            System.err.println("Erro ao carregar ou salvar a imagem: " + e.getMessage());
        }
    }

    private static BufferedImage duplicarImagem(BufferedImage original) {
        BufferedImage copia = new BufferedImage(original.getWidth(), original.getHeight(), original.getType());
        Graphics g = copia.getGraphics();
        g.drawImage(original, 0, 0, null);
        g.dispose();
        return copia;
    }
}
