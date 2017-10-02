package com.kodilla.good.patterns.challenges.airtransportcompany.repository;

public final class DomesticFlight implements Flight {

    private String from;
    private String to;

    public DomesticFlight(final String from, final String to) {
        this.from = from;
        this.to = to;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DomesticFlight that = (DomesticFlight) o;

        if (!from.equals(that.from)) return false;
        return to.equals(that.to);
    }

    @Override
    public int hashCode() {
        int result = from.hashCode();
        result = 31 * result + to.hashCode();
        return result;
    }
}
