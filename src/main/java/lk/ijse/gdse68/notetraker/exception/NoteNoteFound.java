package lk.ijse.gdse68.notetraker.exception;

public class NoteNoteFound extends RuntimeException {
    public NoteNoteFound() {
        super();
    }

    public NoteNoteFound(String message) {
        super(message);
    }

    public NoteNoteFound(String message, Throwable cause) {
        super(message, cause);
    }
}
