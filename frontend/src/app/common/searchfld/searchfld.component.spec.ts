import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SearchfldComponent } from './searchfld.component';

describe('SearchfldComponent', () => {
  let component: SearchfldComponent;
  let fixture: ComponentFixture<SearchfldComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SearchfldComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SearchfldComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
