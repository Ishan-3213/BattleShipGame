// -----------------------------------------------------
// Assignment 1
// © Ishan Pansuriya, Tanmay Soni
// Written by:
// Ishan Pansuriya: 40232841
// Tanmay Soni: 40240650
// -----------------------------------------------------
package Modals;

import Constants.CellOwner;
import Constants.CellType;

/**
 * Represents a cell on the Battleship game grid.
 * Each cell has a type (SHIP, GRENADE, or NOTHING), an owner (HUMAN, COMPUTER), and a status indicating
 * whether the cell has been called during the game.
 *
 */
public class GridCell {
    private final CellType type;
    private final CellOwner owner;
    private boolean isCalled;

    /**
     * Constructor to initialize a grid cell with a specified type and owner.
     *
     * @param type  The type of the cell (SHIP, GRENADE, or NOTHING).
     * @param owner The owner of the cell (HUMAN or COMPUTER).
     */
    public GridCell(CellType type, CellOwner owner) {
        this.type = type;
        this.owner = owner;
        this.isCalled = false;
    }

    /**
     * Gets the type of the cell.
     *
     * @return The type of the cell (SHIP, GRENADE, or NOTHING).
     */
    public CellType getType() {
        return type;
    }

    /**
     * Gets the owner of the cell.
     *
     * @return The owner of the cell (HUMAN or COMPUTER).
     */
    public CellOwner getOwner() {
        return owner;
    }

    /**
     * Checks if the cell has been called during the game.
     *
     * @return True if the cell has been called, false otherwise.
     */
    public boolean isCalled() {
        return isCalled;
    }

    /**
     * Marks the cell as called during the game.
     */
    public void markAsCalled() {
        isCalled = true;
    }
}
