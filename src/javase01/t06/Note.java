package javase01.t06;

/**
 * Класс "Запись в блокноте".
 *
 */

public class Note {

    // Строка - запись в блокноте.
    private String noteText;


    /**
     * Конструктор по умолчанию (создает пустую запись).
     *
     */
    Note() {
        this.noteText = "";
    }

    /**
     * Конструктор (создает запись с заданным текстом).
     *
     * @param   noteText   текст новой записи
     */
    Note(String noteText) {
        this.noteText = noteText;
    }


    public String getNoteText() {
        return noteText;
    }


    public void setNoteText(String noteText) {
        this.noteText = noteText;
    }

}
