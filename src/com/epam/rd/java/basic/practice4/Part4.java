package com.epam.rd.java.basic.practice4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part4 {

    public static final Logger logger = Logger.getLogger(Part4.class.getName());

    Part4(String filename) {
        setFileName(filename);
    }

    private String path;

    public String getFileName() {
        return path;
    }

    public final void setFileName(String fileName) {
        this.path = fileName;
    }

    public void out(){
        Parser pars;
        pars = new Parser(new File(getFileName()));
        for (String l : pars) {
            System.out.println(l);
        }

    }

    static class Parser implements Iterable<String> {
        private static final String REG = "\\p{Lu}.*?\\.";
        private static final String ENC = "Cp1251";
        private Matcher patternMatcher;

        public Matcher getPatternMatcher() {
            return patternMatcher;
        }

        public final void setPatternMatcher(Matcher patternMatcher) {
            this.patternMatcher = patternMatcher;
        }

        public Parser(File file) {
            StringBuilder sb;
            sb = new StringBuilder();
            Pattern pat;
            pat = Pattern.compile(REG);
            Scanner scanner = null;
            try {
                scanner = new Scanner(file, ENC);
            } catch (FileNotFoundException e) {
                logger.log(Level.SEVERE,"Exception message",e);
            }
            if (scanner != null) {
                while (scanner.hasNextLine()) {
                    sb.append(scanner.nextLine()).append(" ");
                    setPatternMatcher(pat.matcher(sb));
                }
            }
            if (scanner != null) {
                scanner.close();
            }
        }


        private static class IteratorParser implements Iterator<String> {
            private Matcher mat;
            public IteratorParser(Matcher matcher) {
                this.mat = matcher;
            }
            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
            @Override
            public String next(){
                String result;
                try{
                    result = mat.group().replace("  ", " ");
                }catch (NoSuchElementException e){
                    logger.log(Level.SEVERE,"Exception",e);
                    throw new NoSuchElementException();
                }
                return result;
            }
            @Override
            public boolean hasNext() {
                return mat.find();
            }
        }

        @Override
        public Iterator<String> iterator() {
            return new IteratorParser(getPatternMatcher());
        }

    }
    public static void main(String[] args) {
        new Part4("part4.txt").out();
    }
}




