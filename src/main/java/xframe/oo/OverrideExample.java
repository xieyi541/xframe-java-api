package xframe.oo;

import java.io.IOException;

public class OverrideExample {
	
}


class Book {
    void review() throws Exception {}
    void read() throws Exception {}
    void close() throws Exception {}
    void write() throws NullPointerException {}
    void skip() throws IOException {}
    void modify() {}
}

class CourseBook extends Book {
    void review() {}                                     
    void read() throws IOException {}                    
    void close() throws Error {}                         
    void write() throws RuntimeException {}              
//    void skip() throws Exception {}                      
//    void modify() throws IOException {}                  
}