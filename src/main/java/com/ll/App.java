package com.ll;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class App {
    ArrayList<String> quotes = new ArrayList<>();
    ArrayList<String> authors = new ArrayList<>();
    void run() {
        System.out.println("===명언 앱===");
        while (true) {
            System.out.print("명령)");
            Scanner scanner = new Scanner(System.in);
            String cmd = scanner.nextLine();

            if (cmd.equals("종료")) {
                break;
            } else if (cmd.equals("등록")){
                registeredQuote();
            } else if (cmd.equals("목록")) {
                displayQuotes();
            }else if (cmd.startsWith("삭제?id=")) {
                deleteQuote(cmd);
            } else {
                System.out.println("유효하지 않은 명령입니다. 다시 시도하세요.");
            }
        }
    }
    void registeredQuote(){
        Scanner scanner = new Scanner(System.in);

        System.out.print("명언 : ");
        String quote = scanner.nextLine();

        System.out.print("작가 : ");
        String author = scanner.nextLine();

        quotes.add(quote);
        authors.add(author);

        System.out.printf("%d번 명언이 등록되었습니다.\n", quotes.size());
    }

    void displayQuotes() {
        System.out.println("번호 / 작가 / 명언");
        System.out.println("----------------------");

        ArrayList<Integer> indices = new ArrayList<>();
        for (int i=0; i< quotes.size(); i++){
            indices.add(i);
        }
        Collections.reverse(indices);

        for (int i =0; i<quotes.size(); i++){
            int index = indices.get(i);
            System.out.printf("%d / %s / %s\n", i + 1, authors.get(index), quotes.get(index));
        }
    }

    void deleteQuote(String cmd) {
        // Parse the ID from the command
        String idStr = cmd.substring(7);
        try {
            int id = Integer.parseInt(idStr);
            if (id >= 1 && id <= quotes.size()) {
                quotes.remove(id - 1);
                authors.remove(id - 1);
                System.out.printf("%d번 명언이 삭제되었습니다.\n", id);
            } else {
                System.out.println(id + "번 명언은 존재하지 않습니다.");
            }
        } catch (NumberFormatException e) {
            System.out.println("유효한 ID가 아닙니다.");
        }
    }
}