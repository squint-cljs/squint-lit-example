import * as squint_core from 'squint-cljs/core.js';
import * as lit from 'lit';
class MyElement extends lit.LitElement {
  constructor() {
super();const self__ = this;
this.name = "World";
this.count = 0;  }
render() { 
const this$ = this;
const self__ = this;let v__40434__auto__1 = lit.html`<h1>${this$["name"]}</h1><button @click=${this$["_onClick"]} part="button">Click Count: ${self__.count}</button>`;
return v__40434__auto__1;
}
_onClick() { 
const this$ = this;
const self__ = this;self__.count = (self__.count + 1);
;
return this$.dispatchEvent(new CustomEvent("count-changed"));
}};
null;
MyElement["properties"] = ({ "count": ({  }) });
window.customElements.define("my-element", MyElement);
