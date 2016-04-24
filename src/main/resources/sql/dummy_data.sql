/* Populate USER_PROFILE Table */
INSERT INTO user_profile(type)
VALUES ('USER');

INSERT INTO user_profile(type)
VALUES ('ADMIN');

/* Populate APP_USER Table */
INSERT INTO client(first_name, last_name, username, password, state)
VALUES ('Bill','Watcher','bill','abc123', 'Active');

INSERT INTO client(first_name, last_name, username, password, state)
VALUES ('Danny','Theys','danny','abc124', 'Active');

INSERT INTO client(first_name, last_name, username, password, state)
VALUES ('Sam','Smith','sam','abc125', 'Active');

INSERT INTO client(first_name, last_name, username, password, state)
VALUES ('Nicole','Warner','nicole','abc126', 'Active');

INSERT INTO client(first_name, last_name, username, password, state)
VALUES ('Kenny','Roger','kenny','abc127', 'Active');

/* Populate JOIN Table */
INSERT INTO client_user_profile (client_id, user_profile_id)
  SELECT user.id, profile.id FROM client user, user_profile profile
  where user.username='bill' and profile.type='USER';

INSERT INTO client_user_profile (client_id, user_profile_id)
  SELECT user.id, profile.id FROM client user, user_profile profile
  where user.username='danny' and profile.type='USER';

INSERT INTO client_user_profile (client_id, user_profile_id)
  SELECT user.id, profile.id FROM client user, user_profile profile
  where user.username='sam' and profile.type='ADMIN';

INSERT INTO client_user_profile (client_id, user_profile_id)
  SELECT user.id, profile.id FROM client user, user_profile profile
  where user.username='nicole' and profile.type='USER';

INSERT INTO client_user_profile (client_id, user_profile_id)
  SELECT user.id, profile.id FROM client user, user_profile profile
  where user.username='kenny' and profile.type='ADMIN';
