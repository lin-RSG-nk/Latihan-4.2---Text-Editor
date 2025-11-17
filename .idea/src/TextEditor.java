import java.util.Scanner;

public class TextEditor {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        Fungsi fungsi = new Fungsi();
        boolean running = true;

        while (running) {
            try {
                System.out.println("\n=== TEXT EDITOR ===");
                System.out.println("[1] Ketik teks");
                if (fungsi.fiturView) {
                    System.out.println("[2] Lihat isi");
                }
                if (fungsi.fiturUndo) {
                    System.out.println("[3] Undo");
                }
                if (fungsi.fiturRedo) {
                    System.out.println("[4] Redo");
                }
                System.out.println("[0] Exit");
                System.out.print("Pilih: ");

                int menu = input.nextInt();
                input.nextLine();

                if (menu == 1) {
                    System.out.print("Masukkan teks: ");
                    fungsi.type(input.nextLine());
                } else if (menu == 2 && fungsi.fiturView) {
                    System.out.println("\n--- Isi Dokumen ---");
                    System.out.println(fungsi.getText());
                    System.out.println("-------------------");
                } else if (menu == 3 && fungsi.fiturUndo) {
                    fungsi.undo();
                } else if (menu == 4 && fungsi.fiturRedo) {
                    fungsi.redo();
                } else if (menu == 0) {
                    running = false;
                } else {
                    System.out.println("Menu tidak valid!");
                }

            } catch (Exception e) {
                System.out.println("Inputan hanya berupa angka!!!!");
                input.nextLine();
            }

        }
        input.close();
    }
}
