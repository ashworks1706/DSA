b = [["1","2",".",".","3",".",".",".","."],
 ["4",".",".","5",".",".",".",".","."],
 [".","9","8",".",".",".",".",".","3"],
 ["5",".",".",".","6",".",".",".","4"],
 [".",".",".","8",".","3",".",".","5"],
 ["7",".",".",".","2",".",".",".","6"],
 [".",".",".",".",".",".","2",".","."],
 [".",".",".","4","1","9",".",".","8"],
 [".",".",".",".","8",".",".","7","9"]]

# Row check
print("Checking rows...")
valid_rows = True
for i, row in enumerate(b):
    seen = set()
    for cell in row:
        if cell != "." and cell in seen:
            print(f"Duplicate found in row {i+1}: {cell}")
            valid_rows = False
            break
        elif cell != ".":
            seen.add(cell)
    print(f"Row {i+1} checked")

if valid_rows:
    print("All rows valid!")

# Column check
print("\nChecking columns...")
valid_columns = True
for col in range(9):
    seen = set()
    for row in range(9):
        cell = b[row][col]  # This accesses columns properly
        if cell != "." and cell in seen:
            print(f"Duplicate found in column {col+1}: {cell}")
            valid_columns = False
            break
        elif cell != ".":
            seen.add(cell)
    print(f"Column {col+1} checked")

if valid_columns:
    print("All columns valid!")

# Square check
print("\nChecking 3x3 squares...")
valid_squares = True
for box_row in range(0, 9, 3):  # Start indexes: 0, 3, 6
    for box_col in range(0, 9, 3):  # Start indexes: 0, 3, 6
        seen = set()
        for r in range(box_row, box_row + 3):
            for c in range(box_col, box_col + 3):
                cell = b[r][c]
                if cell != "." and cell in seen:
                    print(f"Duplicate found in square at position ({box_row},{box_col}): {cell}")
                    valid_squares = False
                    break
                elif cell != ".":
                    seen.add(cell)
        print(f"Square starting at ({box_row},{box_col}) checked")

if valid_squares:
    print("All squares valid!")

# Final result
print("\nFINAL RESULT:")
if valid_rows and valid_columns and valid_squares:
    print("Sudoku board is VALID!")
else:
    print("Sudoku board is INVALID!")

