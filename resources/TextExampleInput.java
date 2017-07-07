
    Map<String, Integer> keyWords = new TreeMap<>(); // список ключевых слов Java

    public static void main(String[] args) {
        CharParser textParser = new CharParser();
        textParser.start();
    }

    public void start(){
        // заполняем список ключевых слов
        fillKeyWords();

        String inputFileName = "resources\\TextExampleInput.java";
        String outputFileName = "resources\\TextExampleOutput.txt";
        FileReader inFile = null;
        FileWriter outFile = null;

        // обрабатываем файл в потоке
        try{
            inFile = new FileReader(inputFileName);
            outFile = new FileWriter(outputFileName);
            listWords(inFile);

            // выводим список ключевых слов на экран
            String keyWords = getKeyWords();
            System.out.println("Список ключевых слов в файле [" + inputFileName + "]:");
            System.out.println(keyWords);
            //writeString(System.out, keyWords);

            // выводим список ключевых слов в файл
            writeString(outFile, keyWords);
            System.out.println("");
            System.out.println("Список ключевых слов в файле [" + inputFileName + "] выведен в файл [" + outputFileName + "]");

            inFile.close();
            outFile.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }

    }


    // выводим строку в символьный поток вывода
    public void writeString (Writer outStream, String string) throws IOException{
        outStream.write(string);
        outStream.flush();
    }




    // выделяем слова из текста потока
    public void listWords (Reader reader) throws IOException{
        StringBuilder word = new StringBuilder("");
        char c = 0;
        int i = 0;

        //while ((c = (char)inStream.read()) > 0){
        while ((i = reader.read()) > 0){
            c = (char)i;
            //System.out.println(c);

            if (Character.isLetter(c)){
                word.append(c);
            }
            else {
                if (!word.equals("")){ // закончилось слово
                    checkKeyWord(word.toString());
                    word = new StringBuilder("");
                }
            }
        }

        if (!word.equals("")) // последнее слово в файле
            checkKeyWord(word.toString());
    }


    // проверяем является ли слово ключевым
    public void checkKeyWord(String word){
        if (keyWords.containsKey(word)){
            int i = keyWords.get(word);
            keyWords.replace(word,++i);
        }
    }

    // выводим список ключевых слов
    public String getKeyWords(){
        StringBuilder s = new StringBuilder("");

        for(String word: keyWords.keySet()){
            int i = keyWords.get(word);
            if (i > 0){
                s.append(word + ": " + i + "\n");
            }
        }
        return s.toString();
    }

