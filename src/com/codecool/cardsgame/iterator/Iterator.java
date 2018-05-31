package com.codecool.cardsgame.iterator;

import com.codecool.cardsgame.cards.*;
import com.codecool.cardsgame.game.*;
import com.codecool.cardsgame.players.*;
import java.util.*;

public interface Iterator {
   public boolean hasNext();
   public Object next();
}
