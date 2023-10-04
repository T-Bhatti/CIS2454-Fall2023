<?php

function list_stocks() {
    global $database;
    
    $query = 'SELECT symbol, name, current_price, id FROM stocks';

    // prepare the query please
    $statement = $database->prepare($query);

    // run the query please
    $statement->execute();

    // this might be risky if you have HUGE amounts of data
    $stocks = $statement->fetchAll();

    $statement->closeCursor();

    return $stocks;
}

function insert_stock($symbol, $name, $current_price) {
    global $database;
    
    // DANGER DANGER DANGER - SQL Injection risk
    // Don't ever just plug values into a query!
    //$query = "INSERT INTO stocks (symbol, name, current_price) "
    //        . "VALUES ($symbol, $name, $current_price)";
    // instead, use substitutions
    $query = "INSERT INTO stocks (symbol, name, current_price) "
            . "VALUES (:symbol, :name, :current_price)";

    // value binding in PDO protects against sql injection
    $statement = $database->prepare($query);
    $statement->bindValue(":symbol", $symbol);
    $statement->bindValue(":name", $name);
    $statement->bindValue(":current_price", $current_price);

    $statement->execute();

    $statement->closeCursor();
}

function update_stock($symbol, $name, $current_price) {
    global $database;
    
    $query = "update stocks set name = :name, current_price = :current_price "
            . " where symbol = :symbol";

    // value binding in PDO protects against sql injection
    $statement = $database->prepare($query);
    $statement->bindValue(":symbol", $symbol);
    $statement->bindValue(":name", $name);
    $statement->bindValue(":current_price", $current_price);

    $statement->execute();

    $statement->closeCursor();
}

function delete_stock($symbol) {
    global $database;
    
    $query = "delete from stocks "
            . " where symbol = :symbol";

    // value binding in PDO protects against sql injection
    $statement = $database->prepare($query);
    $statement->bindValue(":symbol", $symbol);

    $statement->execute();

    $statement->closeCursor();
}
