package Modals;

import Constants.CellOwner;
import Constants.CellType;

public class GridCell {
    private final CellType type;
    private final CellOwner owner;
    private boolean isCalled;

    public GridCell(CellType type, CellOwner owner) {
        this.type = type;
        this.owner = owner;
        this.isCalled = false;
    }

    public CellType getType() {
        return type;
    }

    public CellOwner getOwner() {
        return owner;
    }

    public boolean isCalled() {
        return isCalled;
    }

    public void markAsCalled() {
        isCalled = true;
    }
}
