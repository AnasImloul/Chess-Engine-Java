package ChessBoard;

import ChessPiece.*;

import java.awt.*;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public class PieceContainer implements Iterable<ChessPiece>{


    private final HashMap<Point, ChessPiece> pieceMap;
    private final HashMap<ChessPiece, Point> positionMap;
    private final HashMap<PieceColor, HashMap<PieceType, Collection<ChessPiece>>> pieceColorTypeMap;

    private int size;

    public PieceContainer(){
        pieceMap = new HashMap<>();
        pieceColorTypeMap = new HashMap<>();
        positionMap = new HashMap<>();
        for (PieceColor color : PieceColor.values()){
            pieceColorTypeMap.put(color, new HashMap<>());
            for (PieceType type : PieceType.values()){
                pieceColorTypeMap.get(color).put(type, new LinkedList<>());
            }
        }
    }
    public void put(ChessPiece piece, Point position){
        if (!contains(position)) size++;
        pieceMap.put(position, piece);
        positionMap.put(piece, position);
        pieceColorTypeMap.get(piece.getColor()).get(piece.getType()).add(piece);
    }

    public ChessPiece get(PieceColor color, PieceType type){
        return pieceColorTypeMap.get(color).get(type).iterator().next();
    }
    public ChessPiece get(Point position){
        return pieceMap.get(position);
    }

    public Point getPosition(ChessPiece piece){
        return positionMap.get(piece);
    }

    public void remove(Point position){
        if (contains(position)) size--;
        ChessPiece piece = pieceMap.remove(position);
        positionMap.remove(piece);
        pieceColorTypeMap.get(piece.getColor()).get(piece.getType()).remove(piece);
    }
    public boolean contains(Point position){
        return pieceMap.containsKey(position);
    }

    public boolean contains(ChessPiece piece){
        return pieceColorTypeMap.get(piece.getColor()).get(piece.getType()).contains(piece);
    }

    public boolean isEmpty(){
        return size() == 0;
    }
    public int size(){
        return size;
    }
    @Override
    public Iterator<ChessPiece> iterator() {
        return pieceMap.values().iterator();
    }
}
