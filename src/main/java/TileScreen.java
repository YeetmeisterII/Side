import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class TileScreen extends JFrame {
    public TileScreen() {
        initUI();
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            var program = new TileScreen();
            program.setVisible(true);
        });
    }

    private void createLayout() {
        GridLayout gridLayout = new GridLayout(10, 10);
        JPanel panel = new JPanel(gridLayout);
        ArrayList<Tile> tiles = createTiles();
        for (Tile tile : tiles) {
            panel.add(tile);
        }
        getContentPane().add(panel);
//        pack();
    }

    private void initUI() {
        setSize(300, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Tiles");
        createLayout();
    }

    private ArrayList<Tile> createTiles() {
        ArrayList<Tile> tiles = new ArrayList<>(100);
        for (int i = 0; i < 100; i++) {
            tiles.add(createColouredTile((i << 16) + (i << 8) + i));
        }
        return tiles;
    }

    private Tile createColouredTile(int rgb) {
        Tile tile = new Tile();
        System.out.println(rgb);
        tile.setBackground(new Color(rgb));
        tile.setMinimumSize(new Dimension(100, 50));
        return tile;
    }
}

class Tile extends JLabel {
    public Tile() {
        super("", null, LEADING);
    }

    @Override
    public boolean isOpaque() {
        return true;
    }
}