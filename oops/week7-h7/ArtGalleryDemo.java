class ArtPiece {
    protected String title;

    public ArtPiece(String title) {
        this.title = title;
    }

    public void displayInfo() {
        System.out.println("Art Piece: " + title);
    }
}

class Painting extends ArtPiece {
    private String brushTechnique;
    private String colorPalette;
    private String frame;

    public Painting(String title, String brushTechnique, String colorPalette, String frame) {
        super(title);
        this.brushTechnique = brushTechnique;
        this.colorPalette = colorPalette;
        this.frame = frame;
    }

    public void showDetails() {
        System.out.println("Painting: " + title + " | Brush: " + brushTechnique + " | Colors: " + colorPalette + " | Frame: " + frame);
    }
}

class Sculpture extends ArtPiece {
    private String material;
    private String dimensions;
    private String lighting;

    public Sculpture(String title, String material, String dimensions, String lighting) {
        super(title);
        this.material = material;
        this.dimensions = dimensions;
        this.lighting = lighting;
    }

    public void showDetails() {
        System.out.println("Sculpture: " + title + " | Material: " + material + " | Dimensions: " + dimensions + " | Lighting: " + lighting);
    }
}

class DigitalArt extends ArtPiece {
    private String resolution;
    private String fileFormat;
    private boolean interactive;

    public DigitalArt(String title, String resolution, String fileFormat, boolean interactive) {
        super(title);
        this.resolution = resolution;
        this.fileFormat = fileFormat;
        this.interactive = interactive;
    }

    public void showDetails() {
        System.out.println("Digital Art: " + title + " | Resolution: " + resolution + " | Format: " + fileFormat + " | Interactive: " + interactive);
    }
}

class Photography extends ArtPiece {
    private String cameraSettings;
    private String editingDetails;
    private String printSpecs;

    public Photography(String title, String cameraSettings, String editingDetails, String printSpecs) {
        super(title);
        this.cameraSettings = cameraSettings;
        this.editingDetails = editingDetails;
        this.printSpecs = printSpecs;
    }

    public void showDetails() {
        System.out.println("Photography: " + title + " | Camera: " + cameraSettings + " | Editing: " + editingDetails + " | Print: " + printSpecs);
    }
}

public class ArtGalleryDemo {
    public static void main(String[] args) {
        ArtPiece[] gallery = new ArtPiece[4];
        gallery[0] = new Painting("Sunset Bliss", "Impasto", "Warm Tones", "Golden Frame");
        gallery[1] = new Sculpture("The Thinker", "Bronze", "180x80x90 cm", "Spotlight");
        gallery[2] = new DigitalArt("Virtual Dreams", "4K", "PNG", true);
        gallery[3] = new Photography("Urban Night", "ISO 800, f/2.8", "Lightroom Edit", "A3 Print");

        for (ArtPiece art : gallery) {
            art.displayInfo();
            if (art instanceof Painting) {
                ((Painting) art).showDetails();
            } else if (art instanceof Sculpture) {
                ((Sculpture) art).showDetails();
            } else if (art instanceof DigitalArt) {
                ((DigitalArt) art).showDetails();
            } else if (art instanceof Photography) {
                ((Photography) art).showDetails();
            }
            System.out.println();
        }
    }
}
