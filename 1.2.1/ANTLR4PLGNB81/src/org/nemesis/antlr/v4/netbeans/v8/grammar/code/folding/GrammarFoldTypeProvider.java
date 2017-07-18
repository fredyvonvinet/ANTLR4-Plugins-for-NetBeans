/*
BSD License

Copyright (c) 2016, Frédéric Yvon Vinet
All rights reserved.

Redistribution and use in source and binary forms, with or without
modification, are permitted provided that the following conditions are met:

* Redistributions of source code must retain the above copyright
  notice, this list of conditions and the following disclaimer.
* Redistributions in binary form must reproduce the above copyright
  notice, this list of conditions and the following disclaimer in the
  documentation and/or other materials provided with the distribution.
* The name of its author may not be used to endorse or promote products
  derived from this software without specific prior written permission.

THIS SOFTWARE IS PROVIDED BY THE AUTHOR ``AS IS'' AND ANY
EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
DISCLAIMED. IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR ANY DIRECT, INDIRECT,
INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT 
LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR 
PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF 
LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE
OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF 
ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
*/
package org.nemesis.antlr.v4.netbeans.v8.grammar.code.folding;

import java.util.ArrayList;
import java.util.Collection;

import org.netbeans.api.editor.fold.FoldType;
import org.netbeans.spi.editor.fold.FoldTypeProvider;

import org.netbeans.api.editor.mimelookup.MimeRegistration;

/**
 *
 * @author Frédéric Yvon Vinet
 */
@MimeRegistration(mimeType = "text/x-g4", service = FoldTypeProvider.class, position = 667)
public class GrammarFoldTypeProvider implements FoldTypeProvider {
    private final Collection<FoldType> types = new ArrayList<>();
    
    public GrammarFoldTypeProvider() {
        types.add(GrammarFoldType.COMMENT_FOLD_TYPE);
        types.add(GrammarFoldType.ACTION_FOLD_TYPE);
    }
    
    @Override
    public Collection<? extends FoldType> getValues(Class type) {
        return type == FoldType.class ? types : null;
    }

    @Override
    public boolean inheritable() {
        return false;
    }
}