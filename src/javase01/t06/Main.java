package javase01.t06;

/**
 * Пример использования класса "Блокнот" (NotePad).
 *
 */

public class Main {

    public static void main(String[] args) {
        testNotePad();
    }

    /**
     * Метод демонстрирует возможности добавления, редактирования, удаления, просмотра записей в блокноте.
     */
    public static void testNotePad() {
        NotePad notePad = new NotePad();

        // добавляем записи
        notePad.addNote("note 0");
        notePad.addNote("note 1");
        notePad.addNote("note 2");
        notePad.addNote("note 3");
        System.out.println("все записи:");
        notePad.showAllNotes();

        // редактируем записи
        notePad.editNote(2, "note text 2");
        System.out.println("");
        System.out.println("записи после редактирования:");
        notePad.showAllNotes();

        // удаляем записи
        notePad.deleteNote(3);
        notePad.deleteNote(1);
        System.out.println("");
        System.out.println("записи после удаления:");
        notePad.showAllNotes();
    }

}
