import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class FloodFillPanel extends JPanel {
    private BufferedImage imagemAtual;

    public FloodFillPanel(BufferedImage imagem) {
        this.imagemAtual = imagem;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (imagemAtual != null) {
            g.drawImage(imagemAtual, 0, 0, null);
        }
    }

    public void atualizarImagem(BufferedImage novaImagem) {
        this.imagemAtual = novaImagem;
        repaint();
    }
}
