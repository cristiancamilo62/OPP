//Sam Smith & Kim Petras - Unholy ( Lyrics) , Creepin' - Metro Boomin, The Weeknd, 21 Savage
package com.camilo.gameguayabita.domain;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Guayabita {
    public static final ImageIcon APP_ICON = new ImageIcon(Guayabita.class.getResource("guayaba.png"));
    public static final ImageIcon APP_DADO1 = new ImageIcon(Guayabita.class.getResource("dado1.png"));
    public static final ImageIcon APP_DADO2 = new ImageIcon(Guayabita.class.getResource("dado2.png"));
    public static final ImageIcon APP_DADO3 = new ImageIcon(Guayabita.class.getResource("dado3.png"));
    public static final ImageIcon APP_DADO4 = new ImageIcon(Guayabita.class.getResource("dado4.png"));
    public static final ImageIcon APP_DADO5 = new ImageIcon(Guayabita.class.getResource("dado5.png"));
    public static final ImageIcon APP_DADO6 = new ImageIcon(Guayabita.class.getResource("dado6.png"));
    public static final ImageIcon Winner = new ImageIcon(Guayabita.class.getResource("ganador.png"));
    public static final String APP_TITLE = "Guayabita";
    public static final Object[] APP_OPTIONS2 = Arrays.asList("aceptar", "cancelar").toArray();
    public static final Object[] APP_OPTIONS3 = Arrays.asList("jugar", "ver instrucciones", "salir").toArray();
    private String name;
    private byte numberOfPlayers;
    private double moneyToTheBet;
    private List<Player> players;
    private List<Player> deleted;

    public Guayabita(String name) {
        this.name = name;
        players = new ArrayList<>();
        deleted = new ArrayList<>();
    }

    public void WelcomeToTheGame() {
       int decision;
            decision = JOptionPane.showOptionDialog(null, "Bienvenido al juego " + getName() + ".\n¿que quieres hacer?", APP_TITLE, JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, APP_ICON, APP_OPTIONS3, null);
            if (decision == JOptionPane.YES_OPTION) {
                byte amountPlayers = askNumberOfPlayers();
                addMoneyToTheBet();
                addNameAndMoneyOfThePlayers(amountPlayers);
                startDiceRoll();
                winningPlayer();
            } else if (decision == 1) {
                seeGameInstructions();
                WelcomeToTheGame();
            }
    }

    public void seeGameInstructions() {
        JOptionPane.showMessageDialog(null, "El juego la guayabita consiste en que n jugadores apuesten dinero a traves de lanzar un dado.\n" +
                "1. Lo primero que se hara es pedir la cantidad de jugadores.\n" +
                "Nota : la cantidad de jugadores debe ser mayor a 1\n" +
                "2. Se les pedira que ingrese en pote que quieren tener como apuesta inicial.\n" +
                "3. A continuación, se le pedirá que ingrese el nombre y la cantidad de dinero que cada jugador tiene para apostar\n" +
                "4. Una vez que se han ingresado los nombres y el dinero de todos los jugadores, el juego comenzará automáticamente.\n" +
                "   A cada jugador se le preguntara si desea lanzar el dado, en caso de que el jugador desida no lanzarlo\n" +
                "   sera eliminado automaticamente, si el jugar desidio lanzar el dado, se le preguntara si decide realizar una apuesta.\n" +
                "Nota : En el primer lanzamiento el dado debe ser diferente de 1 y 6, ademas la apuesta debe ser menor a la cantidad del pote\n" +
                "5. Si un jugador se queda sin dinero, será eliminado del juego. El juego continuará hasta que quede un solo jugador\n" +
                "   o hasta que el pote quede sin dinero\n" +
                "6. Cuando finalice el juego, se mostrará un mensaje de felicitación al jugador ganador, junto con la cantidad de dinero que ha ganado.\n" +
                "   Ademas de eso se mostraran los jugadores que quedaron en juego, y los jugadores que fueron eliminadores.", APP_TITLE, JOptionPane.INFORMATION_MESSAGE, APP_ICON);
    }

    public byte askNumberOfPlayers() {
        byte numbersOfPlayers = 0;
        boolean puedeContinuar = true;
        String mensaje = "Ingrese el número de jugadores";
        do {
            numbersOfPlayers = (byte) Exception_e(mensaje);
            if (numbersOfPlayers > 1) {
                this.numberOfPlayers = numbersOfPlayers;
                puedeContinuar = true;
            } else {
                JOptionPane.showMessageDialog(null, "El número debe ser mayor que 1", APP_TITLE, JOptionPane.INFORMATION_MESSAGE, APP_ICON);
                puedeContinuar = false;
            }
        } while (!puedeContinuar);
        return numbersOfPlayers;
    }

    public void addNameAndMoneyOfThePlayers(byte amountPlayers) {
        String name;
        double money_player;
        for (int pos = 0; pos < this.numberOfPlayers; pos++) {
            boolean puedeContinuar = false;

            do {
                try {
                    name = JOptionPane.showInputDialog(null, "Ingrese el nombre del jugador " + (pos + 1), APP_TITLE, JOptionPane.QUESTION_MESSAGE, APP_ICON, null, "").toString().trim();
                    if (name == null || (name.isEmpty())) {
                        JOptionPane.showMessageDialog(null, "La celda no puede estar vacia", APP_TITLE, JOptionPane.INFORMATION_MESSAGE, APP_ICON);
                    } else {
                        do {
                            String mensaje = "Ingrese el dinero de " + name;
                            money_player = Exception_e(mensaje);
                            if (money_player - (this.moneyToTheBet / amountPlayers) <= 0) {
                                JOptionPane.showMessageDialog(null, "La cantidad de dinero debe ser mayor", APP_TITLE, JOptionPane.INFORMATION_MESSAGE, APP_ICON);
                                puedeContinuar = false;
                            } else {
                                money_player -= (moneyToTheBet / amountPlayers);
                                Player player = new Player(name, money_player);
                                players.add(player);
                                puedeContinuar = true;
                            }

                        } while (!puedeContinuar);
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "La celda no puede estar vacia", APP_TITLE, JOptionPane.INFORMATION_MESSAGE, APP_ICON);
                    puedeContinuar = false;
                }
            } while (!puedeContinuar);

        }
    }
    public void addMoneyToTheBet() {
        Object[] options = {"$1000", "$2000", "$3000", "Escriba la cantidad de dinero"};
        boolean puedeContinuar = false;
        do {
            int answer = JOptionPane.showOptionDialog(null,
                    "¿Ingrese el dinero a poner inicialmente en el pote?",
                    APP_TITLE,
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.PLAIN_MESSAGE,
                    APP_ICON,
                    options,
                    options[0]);
            switch (answer) {
                case 0:
                    this.moneyToTheBet = 1000;
                    puedeContinuar = true;
                    break;
                case 1:
                    this.moneyToTheBet = 2000;
                    puedeContinuar = true;
                    break;
                case 2:
                    this.moneyToTheBet = 3000;
                    puedeContinuar = true;
                    break;
                case 3:
                    String mensaje = "Ingrese la cantidad de dinero:";
                    this.moneyToTheBet = Exception_e(mensaje);
                    puedeContinuar = true;
                    break;
            }
        } while (!puedeContinuar);
    }

    public void startDiceRoll() {
        boolean salida = false;
        int decision = -1;
        int amountDeleted = 0;
        while (!salida && this.moneyToTheBet != 0) {
            for (Player py : this.players) {
                String name = py.getName();
                double new_money;
                boolean puedeContinuar = false;
                double money = -1;
                decision = (int) JOptionPane.showOptionDialog(null, name + ", la apuesta esta en " + this.moneyToTheBet + "\ntu dinero total es: " + py.getMoney() + ",\n ¿desea lanzar el dado?",
                        APP_TITLE, JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, APP_ICON, APP_OPTIONS2, "");
                if (decision == 0) {
                    int dado = py.rollDie();
                    int previousRollOfDie = showDie(name, dado);
                    System.out.println(previousRollOfDie);
                    if (previousRollOfDie != 6 && previousRollOfDie != 1) {
                        money = py.bet(this.moneyToTheBet);
                        if (money != 0) {
                            int dado2 = py.rollDie();
                            int currentDieRoll = showDie(name, dado2);
                            if (currentDieRoll > previousRollOfDie) {
                                JOptionPane.showMessageDialog(null, py.getName() + " has ganado " + money, APP_TITLE, JOptionPane.QUESTION_MESSAGE, APP_ICON);
                                new_money = py.getMoney() + money;
                                this.moneyToTheBet -= money;

                            } else {
                                JOptionPane.showMessageDialog(null, py.getName() + " has perdido " + money, APP_TITLE, JOptionPane.INFORMATION_MESSAGE, APP_ICON);
                                new_money = py.getMoney() - money;
                                this.moneyToTheBet += money;
                                if(new_money == 0){
                                    amountDeleted++;
                                }

                            }
                            py.setMoney(new_money);
                        } else {
                            JOptionPane.showMessageDialog(null, "Continua el siguiente jugador", APP_TITLE, JOptionPane.INFORMATION_MESSAGE, APP_ICON);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "No puedes apostar.\nContinua el siguiente jugador", APP_TITLE, JOptionPane.INFORMATION_MESSAGE, APP_ICON);
                        puedeContinuar = true;
                    }
                } else {
                    deleted.add(py);
                    amountDeleted++;
                    JOptionPane.showMessageDialog(null, "Has sido eliminado del juego", APP_TITLE, JOptionPane.INFORMATION_MESSAGE, APP_ICON);
                    puedeContinuar = true;
                }
                if (continueGame(this.moneyToTheBet, py,decision,amountDeleted)) {
                    salida = true;
                    break;
                }
            }
            if (eliminatedPlayers() < 2)
                salida = true;
        }
        JOptionPane.showMessageDialog(null, "El juego a terminado.\nPresiona ok para ver resultados ", APP_TITLE, JOptionPane.INFORMATION_MESSAGE, APP_ICON);
    }

    public int showDie(String name, int randomNumber) {

        switch (randomNumber) {
            case 1:
                JOptionPane.showMessageDialog(null, name + " este es tu dado", APP_TITLE, JOptionPane.INFORMATION_MESSAGE, APP_DADO1);
                break;
            case 2:
                JOptionPane.showMessageDialog(null, name + " este es tu dado", APP_TITLE,
                        JOptionPane.QUESTION_MESSAGE, APP_DADO2);
                break;
            case 3:
                JOptionPane.showMessageDialog(null, name + " este es tu dado", APP_TITLE,
                        JOptionPane.QUESTION_MESSAGE, APP_DADO3);
                break;
            case 4:
                JOptionPane.showMessageDialog(null, name + " este es tu dado", APP_TITLE,
                        JOptionPane.QUESTION_MESSAGE, APP_DADO4);
                break;
            case 5:
                JOptionPane.showMessageDialog(null, name + " este es tu dado\n\n", APP_TITLE,
                        JOptionPane.QUESTION_MESSAGE, APP_DADO5);
                break;
            case 6:
                JOptionPane.showMessageDialog(null, name + " este es tu dado", APP_TITLE,
                        JOptionPane.QUESTION_MESSAGE, APP_DADO6);
                break;
        }
        return randomNumber;
    }

    public boolean continueGame(double moneyToTheBet, Player py,int decision,int amountDeleted) {
        if (moneyToTheBet == 0) {
            return true;
        }
        else if (py.getMoney() == 0) {
            deleted.add(py);
            if(players.size()-amountDeleted >1){
                return  false;
            }
            return true;
        }
        else if(decision == 1){
            if(players.size()-1 >1){
                return  false;
            }
            return  true;
        }
        return false;

    }

    public int eliminatedPlayers() {
        for (Player p : this.deleted) {
            Player pyt = this.players.stream().filter(py -> py.getName().equals(p.getName())).findFirst().orElse(null);
            if (pyt != null) {
                players.remove(pyt);
            }
        }
        return players.size();
    }

    public void winningPlayer() {
        double winningPlayer = 0;
        Player winner = null;
        JOptionPane.showMessageDialog(null, "Jugadores eliminados", APP_TITLE, JOptionPane.INFORMATION_MESSAGE, APP_ICON);
        for (Player p : this.deleted) {
            if (deleted.isEmpty()) {
                JOptionPane.showMessageDialog(null, "No ubieron jugadores eliminados", APP_TITLE, JOptionPane.INFORMATION_MESSAGE, APP_ICON);
            } else {
                JOptionPane.showMessageDialog(null, p.getName() + " Fue eliminado", APP_TITLE, JOptionPane.INFORMATION_MESSAGE, APP_ICON);
            }
        }
        JOptionPane.showMessageDialog(null, "Jugadores que terminaron en juego ", APP_TITLE, JOptionPane.INFORMATION_MESSAGE, APP_ICON);
        for (Player py : this.players) {
            if (py.getMoney() > winningPlayer) {
                winner = py;
                winningPlayer = py.getMoney()+this.moneyToTheBet;
            }
            if (!players.isEmpty()) {
                JOptionPane.showMessageDialog(null, py.getName() + " termino con : " + py.getMoney(), APP_TITLE, JOptionPane.INFORMATION_MESSAGE, APP_ICON);
            } else {
                JOptionPane.showMessageDialog(null, "Todos los jugarores fueron eliminados");
            }
        }
        JOptionPane.showMessageDialog(null, "Jugador ganador es: ", APP_TITLE, JOptionPane.INFORMATION_MESSAGE, APP_ICON);
        JOptionPane.showMessageDialog(null, winner.getName() + " has sido en ganador con " + winningPlayer, "Ganador", JOptionPane.INFORMATION_MESSAGE, Winner);
    }
    public double Exception_e(String mensaje){
        boolean puedeContinuar;
        double money = 0;
        do {
            try {
                String amountMoney = (String) JOptionPane.showInputDialog(null, mensaje, APP_TITLE, JOptionPane.PLAIN_MESSAGE, APP_ICON, null, "");
                amountMoney = amountMoney.trim();
                if (amountMoney == null || (amountMoney.isEmpty())) {
                    JOptionPane.showMessageDialog(null, "La celda no puede estar vacia", APP_TITLE, JOptionPane.INFORMATION_MESSAGE, APP_ICON);
                    puedeContinuar = false;
                } else if (!amountMoney.matches("[0-9]+")) {
                    JOptionPane.showMessageDialog(null, "El valor a ingresar debe ser numerico", APP_TITLE, JOptionPane.INFORMATION_MESSAGE, APP_ICON);
                    puedeContinuar = false;
                } else {
                    money = Double.valueOf(amountMoney.trim());
                    puedeContinuar = true;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null,"No seas suave");
                puedeContinuar = false;
            }
        } while (!puedeContinuar);
        return  money;
    }

    public String getName() {
        return name;
    }




}
