package ethanmmd.mastermind.distributed.dispatchers;

public enum FrameType {
    START,
    STATUS,
    ADD_PROPOSED_COMBINATION,
    GET_PROPOSAL_COMBINATION,
    GET_ATTEMPTS,
    GET_RESULT,
    UNDO,
    REDO,
    UNDOABLE,
    REDOABLE,
    NEXT_STATUS,
    RESUME,
    IS_LOOSER,
    IS_WINNER,
    CLOSE;


    public static FrameType parser(String string) {
        for (FrameType frameType : FrameType.values()) {
            if (frameType.name().equals(string)) {
                return frameType;
            }
        }
        return null;
    }
}


