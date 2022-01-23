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

    public Range getIntersection(Range range) {
        if (isInside(range.getFrom()) && isInside(range.getTo())) {
            return new Range(range.getFrom(), range.getTo());
        } else if (isInside(range.getFrom())) {
            return new Range(range.getFrom(), this.to);
        } else if (isInside(range.getTo())) {
            return new Range(this.from, range.getTo());
        }

        return null;
    }

    public Range[] getUnion(Range range) {
        if (isInside(range.getFrom()) && isInside(range.getTo())) {
            return new Range[]{new Range(this.from, this.to)};
        } else if (isInside(range.getFrom())) {
            return new Range[]{new Range(this.from, range.getTo())};
        } else if (isInside(range.getTo())) {
            return new Range[]{new Range(range.getFrom(), this.to)};
        }

        return new Range[]{new Range(this.from, this.to), new Range(range.getFrom(), range.getTo())};
    }

    public Range[] getComplement(Range range) {
        if (this.from == range.getFrom() && this.to == range.getTo()) {
            return null;
        } else if ((isInside(range.getFrom())) || (this.from == range.getFrom() && isInside(range.getTo()))) {
            return new Range[]{new Range(range.getTo(), this.to)};
        } else if ((isInside(range.getTo())) || (isInside(range.getFrom()) && this.to == range.getTo())) {
            return new Range[]{new Range(this.from, range.getFrom())};
        } else if (isInside(range.getFrom()) && isInside(range.getTo())) {
            return new Range[]{new Range(this.from, range.getFrom()), new Range(range.getTo(), this.to)};
        }

        return new Range[]{new Range(this.from, this.to)};
    }
}
