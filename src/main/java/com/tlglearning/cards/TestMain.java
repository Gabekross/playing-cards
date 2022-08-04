package com.tlglearning.cards;

import com.tlglearning.cards.model.Card;
import com.tlglearning.cards.model.Deck;
import com.tlglearning.cards.model.Rank;
import java.security.SecureRandom;
import java.util.Comparator;
import java.util.EnumSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class TestMain {

  public static void main(String[] args) {
    Deck deck = new Deck();
    Random rng = new SecureRandom();
    System.out.println(deck);
    Set<Rank> excludeCards = EnumSet.range(Rank.TWO, Rank.EIGHT);
    deck.shuffle(rng);

    Spliterator<Card> spliter = Spliterators.spliterator(deck.iterator(), deck.size(), 0);
    List<Card> pinochleCards = StreamSupport
        .stream(spliter,false)
        .filter(card -> !excludeCards.contains(card.getRank()))
        .collect(Collectors.toList());
    System.out.println(pinochleCards);


//    System.out.println(deck);
////    for (Card card : deck){
////      System.out.println(card);
////    }
//
//    deck.sort();
//    System.out.println(deck);
//
//    deck.sort(Comparator.comparing(Card::getRank).thenComparing(Card::getSuit));
//    System.out.println(deck);
  }

}
