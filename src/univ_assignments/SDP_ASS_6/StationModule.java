package univ_assignments.SDP_ASS_6;

/**
 * Element interface of the Visitor pattern.
 * Every part of the station accepts a visitor and nothing else:
 * all operations live in the visitors, not here.
 */
public interface StationModule {

    String getName();

    void accept(StationVisitor visitor);
}
