package javase01_intro.t06;

/**
 * Класс "Блокнот".
 *
 * Представляет из себя массив записей (Note[])
 */


public class NotePad {

    // Блокнот (массив записей в блокноте).
    private Note[] notes = new Note[0];


    /**
     * Добавление записи в блокнот.
     *
     * @param   noteText   текст новой записи
     */
    public void addNote(String noteText){
        Note[] newNotes = new  Note[this.notes.length+1];
        System.arraycopy(this.notes, 0, newNotes, 0, this.notes.length);
        newNotes[newNotes.length-1] = new Note(noteText);
        this.notes = newNotes;
    }


    /**
     * Удаление записи из блокнота.
     *
     * @param   noteNumber   номер удаляемой записи
     */
    public void deleteNote(int noteNumber){
        Note[] newNotes = new  Note[this.notes.length-1];
        System.arraycopy(this.notes, 0, newNotes, 0, noteNumber);
        System.arraycopy(this.notes, noteNumber+1, newNotes, noteNumber, this.notes.length-1-noteNumber);
        this.notes = newNotes;
    }


    /**
     * Редактирование записи в блокноте.
     *
     * @param   noteNumber   номер записи
     * @param   noteText   новый текст записи
     */
    public void editNote(int noteNumber, String noteText){
        this.notes[noteNumber].setNoteText(noteText);
    }


    /**
     * Просмотр всех записей в блокноте.
     *
     */
    public void showAllNotes(){
        for(Note note: notes){
            System.out.println(note.getNoteText());
        }
    }


}
