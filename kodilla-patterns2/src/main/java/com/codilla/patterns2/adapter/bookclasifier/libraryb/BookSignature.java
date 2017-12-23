package com.codilla.patterns2.adapter.bookclasifier.libraryb;

public class BookSignature {
    private final String signatue;

    public BookSignature(String signatue) {
        this.signatue = signatue;
    }

    public String getSignatue() {
        return signatue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BookSignature that = (BookSignature) o;

        return signatue != null ? signatue.equals(that.signatue) : that.signatue == null;
    }

    @Override
    public int hashCode() {
        return signatue != null ? signatue.hashCode() : 0;
    }
}
