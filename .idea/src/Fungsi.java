public class Fungsi {

    private StringBuilder currentText = new StringBuilder();
    private Stack<String> undoStack = new Stack<>();
    private Stack<String> redoStack = new Stack<>();

    public boolean fiturUndo = false;
    public boolean fiturRedo = false;
    public boolean fiturView = false;

    public void type(String text) {
        undoStack.push(currentText.toString());
        redoStack = new Stack<>();
        currentText.append(text);

        fiturUndo = true;
        fiturRedo = false;
        fiturView = true;
    }

    public void undo() {
        if (!undoStack.isEmpty()) {
            redoStack.push(currentText.toString());
            currentText = new StringBuilder(undoStack.pop());

            fiturRedo = true;
            fiturUndo = !undoStack.isEmpty();
        } else {
            fiturUndo = false;
            System.out.println("Tidak ada yang bisa di-undo!");
        }
    }

    public void redo() {
        if (!redoStack.isEmpty()) {
            undoStack.push(currentText.toString());
            currentText = new StringBuilder(redoStack.pop());

            fiturUndo = true;
            fiturRedo = !redoStack.isEmpty();
        } else {
            fiturRedo = false;
            System.out.println("Tidak ada yang bisa di-redo!");
        }
    }

    public String getText() {
        return currentText.toString();
    }
}
