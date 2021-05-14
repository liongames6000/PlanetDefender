package Schule.Planetderfender.Handler;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;

public class GuiHandler
{
    private final JFrame frame;
    private final CanvasPane canvas;
    private final JPanel stearingEast;
    private final JPanel stearingSouth;
    private Graphics2D graphic;
    private Color backgroundColor;
    private Image canvasImage;

    private static GuiHandler singleton;
    private Color customColor;

    /**
     * Erzeugt ein Zeichenfenster mit wei�em Hintergrund.
     * @param title  Fensterueberschirft
     * @param width  Breite des Fensters
     * @param height  Hoehe des Fensters
     */
    public GuiHandler(String title, int width, int height)
    {
        this(title, width, height, Color.white);
    }

    /**
     * Erzeugt ein Zeichenfenster.
     * @param titel  Fensterueberschirft
     * @param width  Breite des Fensters
     * @param heigth  Hoehe des Fensters
     * @param backgroundColor  Hintergrundfarbe des Zeichenfensters
     */
    private GuiHandler(String titel, int width, int heigth, Color backgroundColor)
    {
        frame = new JFrame();
        canvas = new CanvasPane();
        canvas.setPreferredSize(new Dimension(width, heigth));
        frame.getContentPane().add(canvas,BorderLayout.CENTER);
        JPanel p1=new JPanel();
        p1.setLayout(new BorderLayout());
        stearingEast = new JPanel();
        stearingSouth = new JPanel();
        stearingEast.setLayout(new BoxLayout(stearingEast,BoxLayout.Y_AXIS));
        stearingSouth.setLayout(new BoxLayout(stearingSouth,BoxLayout.X_AXIS));
        p1.add(stearingEast,BorderLayout.NORTH);
        frame.getContentPane().add(p1,BorderLayout.EAST);
        frame.getContentPane().add(stearingSouth,BorderLayout.SOUTH);
        frame.setTitle(titel);
        frame.pack();
        show();
    }

    public static GuiHandler getInstance()
    {
        if (singleton==null){singleton=new GuiHandler("PlanetDefender",1920,1080);}
        singleton.show();
        return singleton;
    }

    /**
     * Macht das Zeichenfenster sichtbar bzw. setzt es in den Vordergrund,
     * falls es bereits sichtbar ist.
     */
    public void show()
    {
        if(graphic == null) {
            // nur beim ersten Aufruf wird der Hintergrund mit der Hintergrundfarbe
            // gefuellt
            Dimension size = canvas.getSize();
            canvasImage = canvas.createImage(size.width, size.height);
            graphic = (Graphics2D)canvasImage.getGraphics();
            graphic.setColor(backgroundColor);
            graphic.fillRect(0, 0, size.width, size.height);
            graphic.setColor(Color.black);
        }
        frame.setVisible(true);
    }

    /**
     * Gibt Information �ber die Sichtbarkeit.
     * @return  true falls das Fenster sichtbar ist.
     */
    public boolean isVisible()
    {
        return frame.isVisible();
    }

    /**
     * Zeichnet einen Elipsenbogen (Siehe Graphics.drawArc)
     * @param x x-Koordinate des Elipsenmittelpunkts
     * @param y y-Koordinate des Elipsenmittelpunkts
     * @param XAxsis Halbachse der Elipse in x-Richtung
     * @param YAxsis Halbachse der Elipse in y-Richtung
     * @param startAngle Polarwinkel, an dem der Bogen anf�ngt
     * @param angle Polarwinkel, welchen der Bogen durchl�uft
     */
    public void drawArc(int x, int y, int XAxsis, int YAxsis, int startAngle, int angle)
    {
        graphic.drawArc(x-XAxsis,y-YAxsis,2*XAxsis,2*YAxsis,startAngle,angle);
        canvas.repaint();
    }

    /**
     * Zeichnet einen Kreis (Siehe Graphics.drawOval)
     * @param x x-Koordinate des Mittelpunkts
     * @param y y-Koordinate des Mittelpunkts
     * @param radius Kreisradius
     */
    public void drawCircle(int x, int y, int radius)
    {
        graphic.drawOval(x-radius,y-radius,2*radius,2*radius);
        canvas.repaint();
    }

    /**
     * F�llt das Innere eines Kreises mit der angegebenen Farbe.
     * @param x x-Koordinate des Mittelpunkts
     * @param y y-Koordinate des Mittelpunkts
     * @param radius Kreisradius
     * @param  color  F�llfarbe f�r den Kreis, erlaubt sind "weiss" "schwarz" "rot"
     * "gruen" "blau" "gelb" "magenta" "cyan" "grau"
     */
    public void fillCircle(int x, int y, int radius, String color)
    {
        Color original=graphic.getColor();
        graphic.setColor(colorToColor(color));
        graphic.fillOval(x-radius,y-radius,2*radius,2*radius);
        canvas.repaint();
        graphic.setColor(original);
    }

    /**
     * F�llt das Innere eines Kreises mit der angegebenen Farbe.
     * @param x x-Koordinate des Mittelpunkts
     * @param y y-Koordinate des Mittelpunkts
     * @param radius Kreisradius
     * @param  colornr  F�llfarbnummer f�r den Kreis (0 bis 8)
     */
    public void fillCircle(int x, int y, int radius, int colornr)
    {
        Color original=graphic.getColor();
        graphic.setColor(colorToColor(colornr));
        graphic.fillOval(x-radius,y-radius,2*radius,2*radius);
        canvas.repaint();
        graphic.setColor(original);
    }

    /**
     * L�scht einen Kreis
     * @param x x-Koordinate des Mittelpunkts
     * @param y y-Koordinate des Mittelpunkts
     * @param radius Kreisradius
     */
    public void deleteCircle(int x, int y, int radius)
    {
        Ellipse2D.Double circle = new Ellipse2D.Double(x-radius, y-radius, 2*radius, 2*radius);
        delete(circle);
    }

    /**
     * Zeichnet den Rand des Rechtecks mit der aktuellen Farbe.
     * @param xPos,yPos Koordinaten der linken oberen Ecke
     * @param width, heigth Breite und H�he des Rechtecks
     */
    public void drawRectangle(int xPos, int yPos, int width, int heigth)
    {
        graphic.drawRect(xPos, yPos, width, heigth);
        canvas.repaint();
        // fill(new Rectangle(xPos, yPos, width, heigth));
    }

    /**
     * F�llt das Innere des Rechtecks mit der angegebenen Farbe.
     * @param xPos,yPos Koordinaten der linken oberen Ecke
     * @param width, heigth Breite und H�he des Rechtecks
     * @param  farbe  F�llfarbe f�r das Rechteck, erlaubt sind "weiss" "schwarz" "rot"
     * "gruen" "blau" "gelb" "magenta" "cyan" "grau"
     */
    public void fillRectangle(int xPos, int yPos, int width, int heigth, String farbe)
    {
        Color original=graphic.getColor();
        graphic.setColor(colorToColor(farbe));
        graphic.fillRect(xPos, yPos, width, heigth);
        canvas.repaint();
        graphic.setColor(original);
    }

    /**
     * F�llt das Innere des Rechtecks mit der angegebenen Farbe.
     * @param xPos,yPos Koordinaten der linken oberen Ecke
     * @param width, heigth Breite und H�he des Rechtecks
     * @param  farbnr  F�llfarbnummer f�r das Rechteck (0 bis 8)
     */
    public void fillRectangle(int xPos, int yPos, int width, int heigth, int farbnr)
    {
        Color original=graphic.getColor();
        graphic.setColor(colorToColor(farbnr));
        graphic.fillRect(xPos, yPos, width, heigth);
        canvas.repaint();
        graphic.setColor(original);
    }

    /**
     * L�scht ein Rechteck.
     * @param xPos,yPos Koordinaten der linken oberen Ecke
     * @param width, heigth Breite und H�he des Rechtecks
     */
    public void deleteRectangle(int xPos, int yPos, int width, int heigth)
    {
        delete(new Rectangle(xPos, yPos, width, heigth));
    }

    private Polygon getTriangle(int x1, int y1, int x2, int y2, int x3, int y3)
    {
        Polygon p=new Polygon();
        p.addPoint(x1,y1);
        p.addPoint(x2,y2);
        p.addPoint(x3,y3);
        return p;
    }

    /**
     * Zeichnet den Rand eines Dreiecks mit der aktuellen Farbe.
     * @param x1,y1 Koordinaten des ersten Eckpunkts
     * @param x2,y2 Koordinaten des zweiten Eckpunkts
     * @param x3,y3 Koordinaten des dritten Eckpunkts
     */
    public void drawTriangle(int x1, int y1, int x2, int y2, int x3, int y3)
    {
        graphic.drawPolygon(getTriangle(x1, y1, x2, y2, x3, y3));
        canvas.repaint();
    }

    /**
     * F�llt das Innere eines Dreiecks mit der angegebenen Farbe.
     * @param x1,y1 Koordinaten des ersten Eckpunkts
     * @param x2,y2 Koordinaten des zweiten Eckpunkts
     * @param x3,y3 Koordinaten des dritten Eckpunkts
     * @param  farbe  F�llfarbe f�r das Dreieck, erlaubt sind "weiss" "schwarz" "rot"
     * "gruen" "blau" "gelb" "magenta" "cyan" "grau"
     */
    public void fillTriangle(int x1, int y1, int x2, int y2, int x3, int y3, String farbe)
    {
        Color original=graphic.getColor();
        graphic.setColor(colorToColor(farbe));
        graphic.fillPolygon(getTriangle(x1, y1, x2, y2, x3, y3));
        canvas.repaint();
        graphic.setColor(original);
    }

    /**
     * F�llt das Innere eines Dreiecks mit der angegebenen Farbe.
     * @param x1,y1 Koordinaten des ersten Eckpunkts
     * @param x2,y2 Koordinaten des zweiten Eckpunkts
     * @param x3,y3 Koordinaten des dritten Eckpunkts
     * @param  farbnr  F�llfarbnummer f�r das Dreieck (0 bis 8)
     */
    public void fillTriangle(int x1, int y1, int x2, int y2, int x3, int y3, int farbnr)
    {
        Color original=graphic.getColor();
        graphic.setColor(colorToColor(farbnr));
        graphic.fillPolygon(getTriangle(x1, y1, x2, y2, x3, y3));
        canvas.repaint();
        graphic.setColor(original);
    }

    /**
     * L�scht ein Dreieck
     * @param x1,y1 Koordinaten des ersten Eckpunkts
     * @param x2,y2 Koordinaten des zweiten Eckpunkts
     * @param x3,y3 Koordinaten des dritten Eckpunkts
     */
    public void deleteTriangle(int x1, int y1, int x2, int y2, int x3, int y3)
    {
        delete(getTriangle(x1, y1, x2, y2, x3, y3));
    }

    /**
     * Zeichnet ein Bild in das Zeichnenfenster .
     * @param  image    das anzuzeigende Bild
     * @param  x       x-Koordinate des linken Bildrands
     * @param  y       y-Koordinate des oberen Bildrands
     * @return  gibt eines booleschen Wert zur�ck, der angibt, ob das Bild vollst�ndig geladen
     *          werden konnte
     */
    public boolean drawImage(Image image, int x, int y)
    {
        boolean result = graphic.drawImage(image, x, y, null);
        canvas.repaint();
        return result;
    }

    /**
     * Zeichnet einen Text.
     * @param  text    die anzuzeigende Zeichenkette
     * @param  x       x-Koordinate des linken Rands
     * @param  y       y-Koordinate des oberen Rands
     */
    public void drawText(String text, int x, int y)
    {
        graphic.drawString(text, x, y);
        canvas.repaint();
    }

    /**
     * L�scht einen Text vom Zeichenfenster.
     * @param  text    die zu l�schende Zeichenkette
     * @param  x       x-Koordinate des linken Rands
     * @param  y       y-Koordinate des oberen Rands
     */
    public void deleteText(String text, int x, int y)
    {
        Color original = graphic.getColor();
        graphic.setColor(backgroundColor);
        graphic.drawString(text, x, y);
        graphic.setColor(original);
        canvas.repaint();
    }

    /**
     * Zeichnet eine Strecke ins Zeichenfenster.
     * @param  x1   x-Koordinate des Anfangspunkts der Strecke
     * @param  y1   y-Koordinate des Anfangspunkts der Strecke
     * @param  x2   x-Koordinate des Endpunkts der Strecke
     * @param  y2   y-Koordinate des Endpunkts der Strecke
     */
    public void drawLine(int x1, int y1, int x2, int y2)
    {
        graphic.drawLine(x1, y1, x2, y2);
        canvas.repaint();
    }

    /**
     * Zeichnet den Umriss eines Shape-Objekts.
     * @param  shape  das Shape-Object, welches gezeichnet werden soll
     */
    public void draw(Shape shape)
    {
        graphic.draw(shape);
        canvas.repaint();
    }

    /**
     * F�llt das Innere eines Shape-Objekts mit der angegebenen Farbe.
     * @param  shape  das Shape-Objekt, welches gef�llt werden soll
     * @param  farbe  F�llfarbe f�r das Shape-Objekt, erlaubt sind "weiss" "schwarz" "rot"
     * "gruen" "blau" "gelb" "magenta" "cyan" "grau"
     */
    public void fill(Shape shape, String farbe)
    {
        Color original=graphic.getColor();
        graphic.setColor(colorToColor(farbe));
        graphic.fill(shape);
        canvas.repaint();
        graphic.setColor(original);
    }

    /**
     * F�llt das Innere eines Shape-Objekts mit der angegebenen Farbe.
     * @param  shape  das Shape-Objekt, welches gef�llt werden soll
     * @param  colornr  F�llfarbnummer f�r das Shape-Objekt (0 bis 8)
     */
    public void fill(Shape shape, int colornr)
    {
        Color original=graphic.getColor();
        graphic.setColor(colorToColor(colornr));
        graphic.fill(shape);
        canvas.repaint();
        graphic.setColor(original);
    }

    /**
     * L�scht ein Shape-Objekts.
     * @param  shape  das Shape-Object, welches gel�scht werden soll
     */
    public void delete(Shape shape)
    {
        Color original = graphic.getColor();
        graphic.setColor(backgroundColor);
        graphic.fill(shape);
        graphic.draw(shape);// erase by filling background color
        graphic.setColor(original);
        canvas.repaint();
    }

    /**
     * L�scht das Innere eines Shape-Objekts.
     * @param  shape  das Shape-Object, welches gel�scht werden soll
     */
    public void deleteInner(Shape shape)
    {
        Color original = graphic.getColor();
        graphic.setColor(backgroundColor);
        graphic.fill(shape);              // erase by filling background color
        graphic.setColor(original);
        canvas.repaint();
    }

    /**
     * L�scht den Inhalt des Zeichenfensters.
     */
    public void deleteAll()
    {
        Color original = graphic.getColor();
        graphic.setColor(backgroundColor);
        Dimension size = canvas.getSize();
        graphic.fill(new Rectangle(0, 0, size.width, size.height));
        graphic.setColor(original);
        canvas.repaint();
    }

    /**
     * L�scht den Umriss eines Shape-Objekts.
     * @param  shape  das Shape-Object, dessen Umriss gel�scht werden soll
     */
    public void deleteEdge(Shape shape)
    {
        Color original = graphic.getColor();
        graphic.setColor(backgroundColor);
        graphic.draw(shape);  // L�schen durch �bermalen mit Hintergrundfarbe
        graphic.setColor(original);
        canvas.repaint();
    }



    /**
     * Setzt die Vordergrundfarbe des Zeichenfensters.
     * @param  newColor   neue Vordergrundfarbe
     */
    public void setForegroundColor(String newColor)
    {
        graphic.setColor(colorToColor(newColor));
    }

    private void setForegroundColor(Color newColor)
    {
        graphic.setColor(newColor);
    }

    private void newColor(int r,int g, int b){
        customColor = new Color(r,g,b);
    }

    private Color colorToColor(int colornr)
    {
        Color color = switch (colornr) {
            case 0 -> Color.black;
            case 1 -> Color.blue;
            case 2 -> Color.green;
            case 3 -> Color.cyan;
            case 4 -> Color.red;
            case 5 -> Color.magenta;
            case 6 -> Color.yellow;
            case 7 -> Color.gray;
            case 8 -> Color.white;
            case 9 -> customColor;
            default -> graphic.getColor();
        };
        return color;

    }

    private Color colorToColor(String color)
    {
        if (color=="weiss") return Color.white;
        if (color=="schwarz") return Color.black;
        if (color=="rot") return Color.red;
        if (color=="gruen") return Color.green;
        if (color=="blau") return Color.blue;
        if (color=="gelb") return Color.yellow;
        if (color=="magenta") return Color.magenta;
        if (color=="cyan") return Color.cyan;
        if (color=="grau") return Color.gray;
        if (color=="customColor") return customColor;
        return graphic.getColor();
    }

    private String ColorTocolor(Color color)
    {
        if (color==Color.white) return "white";
        if (color==Color.black) return "black";
        if (color==Color.red) return "red";
        if (color==Color.green) return "green";
        if (color==Color.blue) return "blue";
        if (color==Color.yellow) return "yellow";
        if (color==Color.magenta) return "magenta";
        if (color==Color.cyan) return "cyan";
        if (color==Color.gray) return "gray";
        if (color==customColor) return "customColor";
        return "";
    }

    /**
     * Gibt die aktuelle Vordergrundfarbe des Zeichenfensters zur�ck.
     * @return   die aktuelle Vordergrundfarbe
     */
    public String getForegroundColor()
    {
        return ColorTocolor(graphic.getColor());
    }
    //public Color gibVordergrundFarbe()
    //{
    //    return graphic.getColor();
    //}

    /**
     * Setzt die Hintergrundfarbe des Zeichenfensters.
     * @param  newColor   neue Hintergrundfarbe
     */
    public void setBackgroundColor(String newColor)
    {
        backgroundColor = colorToColor(newColor);
        graphic.setBackground(backgroundColor);
    }
    private void setBackgroundColorroundColor(Color newColor)
    {
        backgroundColor = newColor;
        graphic.setBackground(newColor);
    }

    /**
     * Gibt die aktuelle Hintergrundfarbe des Zeichenfensters zur�ck.
     * @return   die aktuelle Hintergrundfarbe
     */
    public String getBackgroundColor()
    {
        return ColorTocolor(backgroundColor);
    }
    //public Color gibHintergrundFarbe()
    //{
    //    return backgroundColor;
    //}

    /**
     * �ndert den aktuellen Zeichensatz des Zeichenfensters.
     * @param  font   Zeichensatz, der k�nftig f�r Zeichenkettenausgaben verwendet wird
     */
    public void setFont(Font font)
    {
        graphic.setFont(font);
    }

    /**
     * Gibt den aktuellen Zeichensatz des Zeichenfensters zur�ck.
     * @return     den aktuellen Zeichensatz
     **/
    public Font getFont()
    {
        return graphic.getFont();
    }

    /**
     * �ndert die Abmessungen des Zeichenfensters.
     * @param  width    neue Breite
     * @param  height     neue H�he
     */
    public void setSize(int width, int height)
    {
        canvas.setPreferredSize(new Dimension(width, height));
        Image oldImage = canvasImage;
        canvasImage = canvas.createImage(width, height);
        graphic = (Graphics2D)canvasImage.getGraphics();
        graphic.drawImage(oldImage, 0, 0, null);
        frame.pack();
    }

    /**
     * Gibt die Abmessungen des Zeichenfensters zur�ck.
     * @return     die aktuellen Abmessungen des Zeichenfensters
     */
    public Dimension getSize()
    {
        return canvas.getSize();
    }

    /**
     * Wartet eine bestimmte Zeit.
     * Eine kurze Verz�gerung kann z. B. f�r Animationen verwendet werden.
     * @param  zeit  Wartezeit in Millisekunden
     */
    public void wait(int zeit)
    {
        try
        {
            Thread.sleep(zeit);
        }
        catch (InterruptedException e)
        {
            // ignoring exception at the moment
        }
    }

    /**
     * F�gt ein weiteres Steuerungselement in die rechte Steuerungsleiste ein.
     * @param  element  Das einzuf�gende Steuerungselement muss aus JComponent abgeleitet
     * sein. z. B. JButton, JComboBox.
     */
    public void addComponent(JComponent element, String position)
    {
        if (position=="rechts") stearingEast.add(element);
        else if (position=="unten") stearingSouth.add(element);
        frame.pack();
    }

    /**
     * Beschriftet den Titel des Zeichenfensters neu.
     * @param  titleNew  Text der neuen Fenster�berschrift
     */
    public void setTitle(String titleNew)
    {
        frame.setTitle(titleNew);
    }

    /************************************************************************
     * Nested class CanvasPane - the actual canvas component contained in the
     * Canvas frame. This is essentially a JPanel with added capability to
     * refresh the image drawn on it.
     */
    private class CanvasPane extends JPanel
    {
        private static final long serialVersionUID = 20060330L;

        public void paint(Graphics g)
        {
            g.drawImage(canvasImage, 0, 0, null);
        }
    }
}
