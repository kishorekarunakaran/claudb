/*
 * Copyright (c) 2015-2020, Antonio Gabriel Muñoz Conejo <antoniogmc at gmail dot com>
 * Distributed under the terms of the MIT License
 */

package com.github.tonivade.claudb.command.string;

import org.junit.Rule;
import org.junit.Test;

import com.github.tonivade.resp.protocol.RedisToken;
import com.github.tonivade.claudb.command.CommandRule;
import com.github.tonivade.claudb.command.CommandUnderTest;
import com.github.tonivade.claudb.command.string.DecrementCommand;

@CommandUnderTest(DecrementCommand.class)
public class DecrementCommandTest {

  @Rule
  public final CommandRule rule = new CommandRule(this);

  @Test
  public void testExecute() {
    rule.withParams("a")
    .execute()
    .assertThat(RedisToken.integer(-1));

    rule.withParams("a")
    .execute()
    .assertThat(RedisToken.integer(-2));

    rule.withParams("a")
    .execute()
    .assertThat(RedisToken.integer(-3));
  }

}
