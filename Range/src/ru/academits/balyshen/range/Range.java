package ru.academits.balyshen.range;

public class Range {
    private double from;
    private double to;

    public Range(double from, double to) {
        this.from = from;
        this.to = to;
    }

    public double getFrom() {
        return from;
    }

    public void setFrom(double from) {
        this.from = from;
    }

    public double getTo() {
        return to;
    }

    public void setTo(double to) {
        this.to = to;
    }

    public double getLength() {
        return to - from;
    }

    public boolean isInside(double number) {
       return number >= from && number <= to;
    }

    public Range getIntersection (Range range) {
        if (isInside(range.getFrom()) && isInside(range.getTo())) {
            return new Range(range.getFrom(), range.getTo());
        } else if (isInside(range.getFrom())) {
            return new Range(range.getFrom(), this.to);
        } else if (isInside(range.getTo())) {
            return new Range(this.from, range.getTo());
        }

        return null;
    }
}
