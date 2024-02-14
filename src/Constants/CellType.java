// -----------------------------------------------------
// COMP6481 Assignment 1
// © Ishan Pansuriya, Tanmay Soni
// Written by:
// Ishan Pansuriya: 40232841
// Tanmay Soni: 40240650
// Due Date: 14th February 2024
// -----------------------------------------------------

package Constants;

/**
 * Enumeration representing the possible types of a cell in a game grid.
 * It includes values for ships, grenades, and empty cells.
 */
public enum CellType {
    /**
     * Represents a cell containing a ship in a game grid.
     */
    SHIP,

    /**
     * Represents a cell containing a grenade in a game grid.
     */
    GRENADE,

    /**
     * Represents an empty cell in a game grid with no ship or grenade.
     */
    NOTHING
}
