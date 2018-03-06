CREATE TABLE comment_ratings
(
  Id         BIGINT AUTO_INCREMENT
    PRIMARY KEY,
  value      SMALLINT(6) NOT NULL,
  user_id    BIGINT      NOT NULL,
  comment_id BIGINT      NOT NULL,
  CONSTRAINT UK_ajnq68hlfg61859csx9w4cpf3
  UNIQUE (comment_id, user_id)
)
  ENGINE = InnoDB;

CREATE INDEX FK_onw2y4m1c1vaqw5du9xmqnfti
  ON comment_ratings (user_id);

CREATE TABLE comments
(
  Id               BIGINT AUTO_INCREMENT
    PRIMARY KEY,
  commentText      LONGTEXT NOT NULL,
  dateTime         DATETIME NOT NULL,
  deleted          BIT      NOT NULL,
  modifiedDateTime DATETIME NULL,
  parent_id        BIGINT   NULL,
  post_id          BIGINT   NOT NULL,
  user_id          BIGINT   NOT NULL,
  CONSTRAINT FK_29ieo90ejocayoeb49npnud06
  FOREIGN KEY (parent_id) REFERENCES comments (Id)
)
  ENGINE = InnoDB;

CREATE INDEX FK_29ieo90ejocayoeb49npnud06
  ON comments (parent_id);

CREATE INDEX FK_2ocgo3lfadb3wq0tx8wyt7sj2
  ON comments (post_id);

CREATE INDEX FK_1x3vdhb5vv8eu5708riqe07wc
  ON comments (user_id);

ALTER TABLE comment_ratings
  ADD CONSTRAINT FK_8i5n7vq6vqlnp4p1outbfb5p0
FOREIGN KEY (comment_id) REFERENCES comments (Id);

CREATE TABLE persistent_logins
(
  username  VARCHAR(64)                         NOT NULL,
  series    VARCHAR(64)                         NOT NULL
    PRIMARY KEY,
  token     VARCHAR(64)                         NOT NULL,
  last_used TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL ON UPDATE CURRENT_TIMESTAMP
)
  ENGINE = InnoDB;

CREATE TABLE post_ratings
(
  Id      BIGINT AUTO_INCREMENT
    PRIMARY KEY,
  value   SMALLINT(6) NOT NULL,
  user_id BIGINT      NOT NULL,
  post_id BIGINT      NOT NULL,
  CONSTRAINT UK_lnj3k5iveutdd7pjjoxpgqchi
  UNIQUE (post_id, user_id)
)
  ENGINE = InnoDB;

CREATE INDEX FK_ecq81thfciu6ccte1p129w0qc
  ON post_ratings (user_id);

CREATE TABLE posts
(
  Id            BIGINT AUTO_INCREMENT
    PRIMARY KEY,
  dateTime      DATETIME     NOT NULL,
  fullPostText  LONGTEXT     NOT NULL,
  hidden        BIT          NOT NULL,
  shortTextPart LONGTEXT     NULL,
  title         VARCHAR(250) NOT NULL
)
  ENGINE = InnoDB;

ALTER TABLE comments
  ADD CONSTRAINT FK_2ocgo3lfadb3wq0tx8wyt7sj2
FOREIGN KEY (post_id) REFERENCES posts (Id);

ALTER TABLE post_ratings
  ADD CONSTRAINT FK_omkkm7q56i2u9qusgwm5kuolh
FOREIGN KEY (post_id) REFERENCES posts (Id);

CREATE TABLE posts_tags
(
  post_id BIGINT NOT NULL,
  tag_id  BIGINT NOT NULL,
  CONSTRAINT FK_gctjaronqwf538fpvsnqs6mhq
  FOREIGN KEY (post_id) REFERENCES posts (Id)
)
  ENGINE = InnoDB;

CREATE INDEX FK_gctjaronqwf538fpvsnqs6mhq
  ON posts_tags (post_id);

CREATE INDEX FK_fab35amw855xeb0ogtmssqx3o
  ON posts_tags (tag_id);

CREATE TABLE roles
(
  Id   BIGINT AUTO_INCREMENT
    PRIMARY KEY,
  name VARCHAR(50) NOT NULL,
  CONSTRAINT UK_ofx66keruapi6vyqpv6f2or37
  UNIQUE (name)
)
  ENGINE = InnoDB;

CREATE TABLE tags
(
  Id   BIGINT AUTO_INCREMENT
    PRIMARY KEY,
  name VARCHAR(30) NOT NULL,
  CONSTRAINT UK_t48xdq560gs3gap9g7jg36kgc
  UNIQUE (name)
)
  ENGINE = InnoDB;

ALTER TABLE posts_tags
  ADD CONSTRAINT FK_fab35amw855xeb0ogtmssqx3o
FOREIGN KEY (tag_id) REFERENCES tags (Id);

CREATE TABLE users
(
  Id               BIGINT AUTO_INCREMENT
    PRIMARY KEY,
  aboutText        VARCHAR(1000) NULL,
  bigAvatarLink    VARCHAR(255)  NULL,
  email            VARCHAR(50)   NOT NULL,
  enabled          BIT           NOT NULL,
  password         VARCHAR(80)   NOT NULL,
  registrationDate DATETIME      NOT NULL,
  smallAvatarLink  VARCHAR(255)  NULL,
  username         VARCHAR(50)   NOT NULL,
  websiteLink      VARCHAR(80)   NULL,
  CONSTRAINT UK_6dotkott2kjsp8vw4d0m25fb7
  UNIQUE (email),
  CONSTRAINT UK_r43af9ap4edm43mmtq01oddj6
  UNIQUE (username)
)
  ENGINE = InnoDB;

ALTER TABLE comment_ratings
  ADD CONSTRAINT FK_onw2y4m1c1vaqw5du9xmqnfti
FOREIGN KEY (user_id) REFERENCES users (Id);

ALTER TABLE comments
  ADD CONSTRAINT FK_1x3vdhb5vv8eu5708riqe07wc
FOREIGN KEY (user_id) REFERENCES users (Id);

ALTER TABLE post_ratings
  ADD CONSTRAINT FK_ecq81thfciu6ccte1p129w0qc
FOREIGN KEY (user_id) REFERENCES users (Id);

CREATE TABLE users_roles
(
  user_id BIGINT NOT NULL,
  role_id BIGINT NOT NULL,
  CONSTRAINT FK_1hjw31qvltj7v3wb5o31jsrd8
  FOREIGN KEY (user_id) REFERENCES users (Id),
  CONSTRAINT FK_k2mq1ee4ob6uw649wgaus1ate
  FOREIGN KEY (role_id) REFERENCES roles (Id)
)
  ENGINE = InnoDB;

CREATE INDEX FK_1hjw31qvltj7v3wb5o31jsrd8
  ON users_roles (user_id);

CREATE INDEX FK_k2mq1ee4ob6uw649wgaus1ate
  ON users_roles (role_id);

