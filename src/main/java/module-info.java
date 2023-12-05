/**
 * The MIT License
 *
 * Copyright (C) 2015 Asterios Raptis
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and
 * associated documentation files (the "Software"), to deal in the Software without restriction,
 * including without limitation the rights to use, copy, modify, merge, publish, distribute,
 * sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or
 * substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT
 * NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM,
 * DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
module ent.core
{
	requires java.persistence;
	requires lombok;
	requires data.api;

	exports io.github.astrapi69.entity.activatable;
	exports io.github.astrapi69.entity.creatable;
	exports io.github.astrapi69.entity.deletable;
	exports io.github.astrapi69.entity.identifiable;
	exports io.github.astrapi69.entity.modifiable;
	exports io.github.astrapi69.entity.nameable;
	exports io.github.astrapi69.entity.nameable.activatable;
	exports io.github.astrapi69.entity.nameable.versionable;
	exports io.github.astrapi69.entity.pairable;
	exports io.github.astrapi69.entity.traceable;
	exports io.github.astrapi69.entity.traceable.versionable;
	exports io.github.astrapi69.entity.treeable;
	exports io.github.astrapi69.entity.uniqueable;
	exports io.github.astrapi69.entity.validatable;
	exports io.github.astrapi69.entity.validatable.versionable;
	exports io.github.astrapi69.entity.verifiable;
	exports io.github.astrapi69.entity.versionable;
	exports io.github.astrapi69.entity.visibility;
}