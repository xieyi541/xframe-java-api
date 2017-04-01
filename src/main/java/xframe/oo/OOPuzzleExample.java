package xframe.oo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class OOPuzzleExample {

	public static void main(String[] args)throws Exception {
        Book1 book = new CourseBook1();             //#1
        book.review(1, null);                     //#A
    }
}

class Book1 {
    void review(int id, List names) throws Exception {              //#1
        System.out.println("Base:review");
    }
}
class CourseBook1 extends Book1 {
    void review(int id, ArrayList names) throws IOException {       //#A
        System.out.println("Derived:review");
    }
}
