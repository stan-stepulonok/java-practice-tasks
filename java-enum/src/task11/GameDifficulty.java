package task11;

public enum GameDifficulty {

    EASY {
        @Override
        public void createEnemy(Player player) {
            player.enemies.add(new Enemy("Easy Enemy", 50));
        }
    },
    MEDIUM,
    HARD {
        @Override
        public void createEnemy(Player player) {
            player.enemies.add(new Enemy("Hard Enemy", 200));
        }
    };

    public void createEnemy(Player player) {
        player.enemies.add(new Enemy("Regular Enemy", 100));
    }


}
