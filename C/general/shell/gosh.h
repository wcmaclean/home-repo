struct command_t {
  char * command_name;
  char *args[1024];
  char infile[256];
  char outfile[256];
  int num_args;
};

void int_func(int);
void tstp_func(int);

int init_command(struct command_t *);
int print_command(struct command_t *, const char *);

int simple_accept_input(struct command_t *);
int token_accept_input(struct command_t *, struct command_t *);

int start_sig_catchers(void);
void int_func(int);
void tstp_func(int);
void chld_func(int);

int simple_fork_command(struct command_t *);
int io_fork_command(struct command_t *);
int iopipe_fork_command(struct command_t *, struct command_t *);

static void strip_return(char *stringStrip);

static void string_copy(char str[], char * str_src);
