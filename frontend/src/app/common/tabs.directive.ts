import {Directive, Input, TemplateRef, ViewContainerRef} from '@angular/core';

@Directive({
  selector: '[appTab]'
})
export class TabsDirective {

  @Input('appTab') set tabController(state: {tabId: number,  currentTabId: number}) {
    if (state.tabId === state.currentTabId) {
      this.viewContainer.createEmbeddedView(this.templateRef);
    } else {
      this.viewContainer.clear();
    }
  }
  constructor(private templateRef: TemplateRef<any>,
              private viewContainer: ViewContainerRef) { }

}
