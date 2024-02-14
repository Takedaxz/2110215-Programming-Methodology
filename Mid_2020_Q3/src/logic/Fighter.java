package logic;

public class Fighter extends Piece{
    private boolean promoted;
    private PositionList promotedMovePositions;
    public Fighter(int initialPositionX, int initialPositionY, boolean reverse, String name) {
        super(initialPositionX, initialPositionY, reverse, name);
        promotedMovePositions=new PositionList();
        movePositions.add(-1,2);
        movePositions.add(1,2);
        promotedMovePositions.add(0,2);
        promotedMovePositions.add(1,0);
        promotedMovePositions.add(0,-2);
        promotedMovePositions.add(-1,0);
        if(isReverse()){
            for(Position position:movePositions){
                position.reverse();
            }
            for(Position position:promotedMovePositions){
                position.reverse();
            }
        }
        setPromoted(false);
    }

    @Override
    public void move(int movePattern) {
        if(isPromoted()) {
            setCurrentPosition(getCurrentPosition().addPositionValue(getPromotedMovePositions().get(movePattern)));
        }
        else{
            setCurrentPosition(getCurrentPosition().addPositionValue(getMovePositions().get(movePattern)));
        }
        this.currentPosition.normalizedPosition();
    }

    @Override
    public Position attackTargetPosition(int actionPattern) {
        Position targetPosition = this.currentPosition.addPositionValue(movePositions.get(actionPattern));
        targetPosition.normalizedPosition();
        setCurrentPosition(targetPosition);
        return targetPosition;
    }

    public boolean isPromoted() {
        return promoted;
    }

    public void setPromoted(boolean promoted) {
        this.promoted = promoted;
    }

    public PositionList getPromotedMovePositions() {
        return promotedMovePositions;
    }

}
