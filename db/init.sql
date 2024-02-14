CREATE TABLE account
(
    id                          SERIAL,
    user_id                     VARCHAR(200) NOT NULL,
    account                     VARCHAR(200) NOT NULL,
    name                        VARCHAR(200) NOT NULL,
    number                      VARCHAR(200) NOT NULL,
    balance                     NUMERIC(1000, 2) NOT NULL,
    currency                    VARCHAR(200) NOT NULL,
    type                        VARCHAR(200) NOT NULL,
    bank                        VARCHAR(200) NOT NULL,
    CONSTRAINT account_pk PRIMARY KEY (id)
);

INSERT INTO public.account
(id, user_id, account, "name", "number", balance, currency, "type", bank)
VALUES(4000, 'CC123454000', '4000', 'Debit', 'D16344', 8002543.00, 'COP', '4000', '4000');